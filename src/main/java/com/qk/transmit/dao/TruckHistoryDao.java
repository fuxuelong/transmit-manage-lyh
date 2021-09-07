package com.qk.transmit.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.transmit.entity.TruckHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 车辆状态历史记录dao
 *
 * @author cgg
 * @date 2019/5/27
 */
@Mapper
@Component
public interface TruckHistoryDao extends CrudDao<TruckHistory> {
    /**
     * 批量插入车辆历史
     *
     * @param list 集合
     */
    void insertBatch(List<TruckHistory> list);

}
