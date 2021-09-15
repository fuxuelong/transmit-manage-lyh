package com.qk.transmit.dao;

import com.qk.commonservice.dao.CrudDao;
import com.qk.transmit.entity.MoveStockApply;
import com.qk.transmit.entity.NewProductFollow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 新产品跟车dao
 *
 * @author lyh
 * @date 2021/9/13
 */
@Component
@Mapper
public interface NewProductFollowDao extends CrudDao<NewProductFollow> {

    /**
     * 删除
     *
     * @param id id
     * @return 返回结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加新产品跟车
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    int insert(NewProductFollow newProductFollow);


    NewProductFollow selectByPrimaryKey(Integer id);


}