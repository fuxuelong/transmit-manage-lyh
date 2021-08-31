package com.qk.transmit.service.impl;

import com.google.common.collect.Maps;
import com.qk.commonservice.commonutil.UserUtils;
import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.impl.CrudServiceImpl;
import com.qk.commonservice.sysentity.User;
import com.qk.commonservice.sysentity.WorkFlow;
import com.qk.transmit.dao.OilApplyDao;
import com.qk.transmit.entity.*;
import com.qk.transmit.service.FlowableServiceClient;
import com.qk.transmit.service.OilApplyService;
import com.qk.transmit.util.TransConstant;
import com.qk.transmit.util.TransUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 加油信息修改申请
 *
 * @author fxl
 * @date 2021/5/8
 */
@Service
public class OilApplyServiceImpl extends CrudServiceImpl<OilApplyDao, OilApply>
        implements OilApplyService {
    @Autowired
    private FlowableServiceClient flowableServiceClient;

    /**
     * 添加加油站
     *
     * @param oilApply 加油站实体类
     * @return 操作结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode addOilApply(OilApply oilApply) {
        oilApply.setStatus(TransConstant.OIL_APPLY_STATUS_SUBMIT);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String format = sdf.format(date);
        String code = "OILAPPLY" + format;
        code = TransUtils.createCode(code, dao);
        oilApply.setCode(code);
        User user = UserUtils.getUser();
        oilApply.setTransportCompanyCode(user.getOffice().getCode());
        oilApply.setTransportCompanyName(user.getOffice().getName());
        oilApply.setOfficeId(user.getOffice().getId());
        save(oilApply);
        // 启动工作流相关参数设置
        Map<String, Object> vars = Maps.newHashMap();
        String title = "编码为" + oilApply.getCode() + "的加油信息修改申请(" + oilApply.getType() + ")";
        vars.put("title", title);
        //拼接businessId，格式：应用名称:流程定义Key:业务记录Id:组织机构Id
        StrBuilder builder = new StrBuilder();
        String businessId = builder.append(applicationName)
                .append(":").append("oilChangeApply")
                .append(":").append(oilApply.getId())
                .append(":").append(UserUtils.getUser().getOffice().getId())
                .toString();
        WorkFlow workFlow = new WorkFlow();
        workFlow.setProcDefKey("oilChangeApply");
        workFlow.setBusinessId(businessId);
        workFlow.setVars(vars);
        // 启动流程
        String procInsId = flowableServiceClient.start(UserUtils.getCurrentToken(), workFlow);
        // 更新流程实例id
        oilApply.setProcessInstanceId(procInsId);
        dao.updateProcInstanceId(oilApply);
        return ResponseCode.OK;
    }

    /**
     * 加油信息审批
     *
     * @param oilApply 仓库对象
     * @return 操作结果，OK为成功 FAIL为失败
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseCode auditOilApply(OilApply oilApply) {
        WorkFlow workFlow = oilApply.getWorkFlow();
        String comment = ("1".equals(workFlow.getFlag()) ? "[同意]" : "[驳回]")
                + (workFlow.getComment() == null ? "" : workFlow.getComment());
        workFlow.setComment(comment);
        Map<String, Object> vars;
        if (oilApply.getWorkFlow().getVars() != null) {
            vars = oilApply.getWorkFlow().getVars();
        } else {
            vars = Maps.newHashMap();
        }
        vars.put("pass", workFlow.getFlag());
        workFlow.setVars(vars);
        // 驳回更新审批状态
        if ("0".equals(workFlow.getFlag())) {
            oilApply.setStatus(TransConstant.OIL_APPLY_STATUS_REJECT);
        } else {
            oilApply.setStatus(TransConstant.OIL_APPLY_STATUS_PASS);
        }
        dao.updateStatus(oilApply);
        // 完成任务
        flowableServiceClient.complete(UserUtils.getCurrentToken(), workFlow);
        return ResponseCode.OK;
    }
}