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

    int deleteByPrimaryKey(Integer id);

    int insert(NewProductFollow record);

    int insertSelective(NewProductFollow record);

    NewProductFollow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProductFollow record);

    int updateByPrimaryKey(NewProductFollow record);

    int updateByCjh(NewProductFollow newProductFollow);
}