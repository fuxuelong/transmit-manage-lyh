package com.qk.transmit.dao;


import com.qk.commonservice.dao.CrudDao;
import com.qk.transmit.entity.OilApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 加油信息申请dao
 *
 * @author fxl
 * @date 2021/5/4
 */
@Component
@Mapper
public interface OilApplyDao extends CrudDao<OilApply> {
    /**
     * 更新流程实例id
     *
     * @return 操作结果
     */
    void updateProcInstanceId(OilApply oilApply);

    /**
     * 更新状态
     *
     * @return 操作结果
     */
    void updateStatus(OilApply oilApply);
}
