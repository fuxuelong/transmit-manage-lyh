package com.qk.transmit.service.impl;

import com.google.common.collect.Maps;
import com.qk.commonservice.commonutil.UserUtils;
import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.impl.CrudServiceImpl;
import com.qk.commonservice.sysentity.User;
import com.qk.commonservice.sysentity.WorkFlow;
import com.qk.transmit.dao.MoveStockApplyDao;
import com.qk.transmit.entity.MoveStockApply;
import com.qk.transmit.service.FlowableServiceClient;
import com.qk.transmit.service.MoveStockApplyService;
import com.qk.transmit.util.TransConstant;
import com.qk.transmit.util.TransUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 移库信息申请修改
 *
 * @author  lyh
 * @date 2021/9/3
 */
@Service
public class MoveStockApplyServiceImpl extends CrudServiceImpl<MoveStockApplyDao, MoveStockApply>
        implements MoveStockApplyService {

    @Autowired
    private FlowableServiceClient flowableServiceClient;

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 添加
     *
     * @param moveStockApply 移库实体对象
     * @return 操作结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode addMoveStockApply(MoveStockApply moveStockApply) {
        moveStockApply.setStatus(TransConstant.MOVE_STOCK_APPLY_STATUS_SUBMIT);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String format = sdf.format(date);
        String code = "MOVESTOCK" + format;
        code = TransUtils.createCode(code, dao);
        moveStockApply.setCode(code);
        User user = UserUtils.getUser();
        moveStockApply.setOfficeId(Integer.parseInt(user.getOffice().getId()));
        save(moveStockApply);
        //获取查询次数
        MoveStockApply check = new MoveStockApply();
        check.setCjh(moveStockApply.getCjh());
        check.setStatus(moveStockApply.getStatus());
        List<MoveStockApply> list = dao.findList(check);
        //查询当前车是否有申请
        check.setStatus(null);
        check.setSqlStr(" AND a.status >=0 AND a.status <15 ");
        List<MoveStockApply> list2 = dao.findList(check);
        if (list2.size()>0){
            ResponseCode fail = ResponseCode.FAIL;
            fail.setMsg("该车辆当前有处于审批流程中的移库申请，不予许添加，审批编码"+list2.get(0).getCode());
            return fail;
        }
        // 启动工作流相关参数设置
        Map<String, Object> vars = Maps.newHashMap();
        String title = "编码为" + moveStockApply.getOfficeId() + "的移库信息修改申请(" + moveStockApply.getCjh() + ")";
        vars.put("title", title);

        //拼接businessId，格式：应用名称:流程定义Key:业务记录Id:组织机构Id
        StrBuilder builder = new StrBuilder();
        String businessId = builder.append(applicationName)
                .append(":").append("MoveStockChangeApply")
                .append(":").append(moveStockApply.getId())
                .append(":").append(UserUtils.getUser().getOffice().getId())
                .toString();
        WorkFlow workFlow = new WorkFlow();
        workFlow.setProcDefKey("MoveStockChangeApply");
        vars.put("times", list.size());
        workFlow.setBusinessId(businessId);
        workFlow.setVars(vars);
        // 启动流程
        String procInsId = flowableServiceClient.start(UserUtils.getCurrentToken(), workFlow);
        // 更新流程实例id
        moveStockApply.setProcessInstanceId(procInsId);
        dao.updateProcInstanceId(moveStockApply);
        return ResponseCode.OK;
    }

    /**
     * 移库申请审批
     *
     * @param moveStockApply 移库实体对象
     * @return 操作结果，OK为成功 FAIL为失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode auditMoveStockApply(MoveStockApply moveStockApply) {
        WorkFlow workFlow = moveStockApply.getWorkFlow();
        String comment = ("1".equals(workFlow.getFlag()) ? "[同意]" : "[驳回]")
                + (workFlow.getComment() == null ? "" : workFlow.getComment());
        workFlow.setComment(comment);
        Map<String, Object> vars;
        if (moveStockApply.getWorkFlow().getVars() != null) {
            vars = moveStockApply.getWorkFlow().getVars();
        } else {
            vars = Maps.newHashMap();
        }
        /*if(moveStockApply.getTimes() >= 5){
            //销管部整车资产管理室审核
            // 提交申请给销管部整车资产管理室模块，审批状态和工作流在那个模块修改，并返回结果
            return restTemplate.postForObject(SALECAEMANAGER_URL + "/auditMoveStockApply",moveStockApply,ResponseCode.class);
        }*/
        vars.put("pass", workFlow.getFlag());
        workFlow.setVars(vars);
        // 驳回更新审批状态
        if ("0".equals(workFlow.getFlag())) {
            moveStockApply.setStatus(TransConstant.MOVE_STOCK_APPLY_STATUS_REJECT);
        } else {
            moveStockApply.setStatus(TransConstant.MOVE_STOCK_APPLY_STATUS_PASS);
        }
        dao.updateStatus(moveStockApply);
        // 完成任务
        flowableServiceClient.complete(UserUtils.getCurrentToken(), workFlow);
        return ResponseCode.OK;
    }

}
