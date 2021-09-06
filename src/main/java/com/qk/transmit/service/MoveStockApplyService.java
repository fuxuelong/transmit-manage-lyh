package com.qk.transmit.service;


import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.CrudService;
import com.qk.transmit.dao.MoveStockApplyDao;
import com.qk.transmit.entity.MoveStockApply;
import org.springframework.stereotype.Component;

@Component
public interface MoveStockApplyService extends CrudService<MoveStockApplyDao, MoveStockApply> {

    /**
     * 添加
     *
     * @param moveStockApply 移库实体对象
     * @return 操作结果
     */
    ResponseCode addMoveStockApply(MoveStockApply moveStockApply);

    /**
     * 修改
     *
     * @param moveStockApply 移库实体对象
     * @return 操作结果
     */
    ResponseCode auditMoveStockApply(MoveStockApply moveStockApply);

}
