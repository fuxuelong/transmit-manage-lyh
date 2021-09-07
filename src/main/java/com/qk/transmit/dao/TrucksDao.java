package com.qk.transmit.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.transmit.entity.Trucks;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 车辆dao
 *
 * @author cgg
 * @date 2019/5/23
 */
@Mapper
@Component
public interface TrucksDao extends CrudDao<Trucks> {
    /**
     * 根据车架号获取车辆信息
     *
     * @param cjh 车架号
     * @return 车辆信息
     */
    Trucks getByCjh(String cjh);
    /**
     * 更新车辆状态
     *
     * @param trucks 车辆实体
     */
    void updateStatus(Trucks trucks);
    /**
     * 更新合格证邮寄状态
     *
     * @param trucks 车辆实体
     */
    void updateHgzPostStatus(Trucks trucks);
    /**
     * 车辆进入共享或非共享状态时更新车辆和车辆状态的信息
     *
     * @param map 车辆状态等信息
     */
    void updateTruckIntoShare(HashMap<String, Object> map);
}
