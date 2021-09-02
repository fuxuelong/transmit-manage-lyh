package com.qk.transmit.dao;


import com.qk.commonservice.dao.CrudDao;
import com.qk.transmit.entity.MoveStockApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 移库申请审批dao
 *
 * @author lyh
 * @date 2021/9/2
 */
@Component
@Mapper
public interface MoveStockApplyDao extends CrudDao<MoveStockApply> {

    /**
     * 移库流程实例id
     *
     * @return 操作结果
     */
    void updateProcInstanceId(MoveStockApply moveStockApply);

    /**
     * 更新状态
     *
     * @return 操作结果
     */
    void updateStatus(MoveStockApply moveStockApply);
}
