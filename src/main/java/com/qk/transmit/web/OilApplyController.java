package com.qk.transmit.web;

import com.github.pagehelper.PageInfo;
import com.qk.commonservice.commonutil.StringUtils;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.sysentity.ResponseJson;
import com.qk.transmit.entity.OilApply;
import com.qk.transmit.service.OilApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 加油信息修改申请
 *
 * @author fxl
 * @date 2020/5/8
 */
@RestController
@RequestMapping("/oilApply")
public class OilApplyController {
    @Autowired
    private OilApplyService oilApplyServiceImpl;

    /**
     * 查询加油信息修改申请列表
     *
     * @param oilApply 销售单实体对象
     * @return 将得到的数据以 List 集合形式返回
     */
    @PostMapping("/getOilApplyList")
    public PageInfo<OilApply> getCheckList(@RequestBody OilApply oilApply) {
        return oilApplyServiceImpl.findPage(oilApply);
    }

    /**
     * 添加
     *
     * @param oilApply 销售单ids
     * @return 返回结果
     */
    @PostMapping("/addOilApply")
    public ResponseJson saveCheck(@RequestBody OilApply oilApply) {
        checkParam(oilApply);
        oilApplyServiceImpl.addOilApply(oilApply);
        return new ResponseJson(ResponseCode.OK);
    }

    /**
     * 修改
     *
     * @param oilApply 销售单ids
     * @return 返回结果
     */
    @PostMapping("/auditOilApply")
    public ResponseJson auditOilApply(@RequestBody OilApply oilApply) {
        Object[] strArray = {oilApply.getId(), oilApply.getWorkFlow().getFlag(),
                oilApply.getWorkFlow().getProcInsId(), oilApply.getWorkFlow().getTaskId(),
                oilApply.getWorkFlow().getTaskDefKey()};
        if (!StringUtils.isAllNotBlank(strArray)) {
            return new ResponseJson(ResponseCode.FAIL, "必传字段为空");
        }
        checkParam(oilApply);
        oilApplyServiceImpl.auditOilApply(oilApply);
        return new ResponseJson(ResponseCode.OK);
    }

    /**
     * 校验必传参数
     *
     * @param oilApply 实体
     */
    private void checkParam(@RequestBody OilApply oilApply) {
        if (StringUtils.isBlank(oilApply.getType())) {
            throw new CommonException(ResponseCode.FAIL, "类型必传");
        }
        if (StringUtils.isBlank(oilApply.getOctaneRating())) {
            throw new CommonException(ResponseCode.FAIL, "加油标号必传");
        }
        if (oilApply.getOilQuantity() == null) {
            throw new CommonException(ResponseCode.FAIL, "加油量必传");
        }
    }

    /**
     * 删除
     *
     * @param id id
     * @return 返回结果
     */
    @PostMapping("/deleteOilApply")
    public ResponseJson delete(@RequestParam String id) {
        oilApplyServiceImpl.delete(id);
        return new ResponseJson(ResponseCode.OK);
    }
}
