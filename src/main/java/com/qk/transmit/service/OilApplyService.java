package com.qk.transmit.service;

import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.CrudService;
import com.qk.transmit.dao.OilApplyDao;
import com.qk.transmit.entity.OilApply;
import org.springframework.stereotype.Component;

/**
 * 加油信息修改申请
 *
 * @author fxl
 * @date 2021/5/4
 */
@Component
public interface OilApplyService extends CrudService<OilApplyDao, OilApply> {
    /**
     * 添加加油信息修改申请
     *
     * @param oilApply 加油信息修改实体类
     * @return 操作结果
     */
    ResponseCode addOilApply(OilApply oilApply);

    /**
     * 审批
     *
     * @param oilApply 加油信息修改实体类
     * @return 操作结果
     */
    ResponseCode auditOilApply(OilApply oilApply);
}
