package com.qk.transmit.service;

import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.CrudService;
import com.qk.transmit.dao.NewProductFollowDao;
import com.qk.transmit.dao.OilApplyDao;
import com.qk.transmit.entity.NewProductFollow;
import com.qk.transmit.entity.OilApply;
import org.springframework.stereotype.Component;

@Component
public interface NewProductFollowService extends CrudService<NewProductFollowDao, NewProductFollow> {


    int deleteByPrimaryKey(Integer id);

    int insert(NewProductFollow record);

    int insertSelective(NewProductFollow record);

    NewProductFollow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProductFollow record);

    int updateByPrimaryKey(NewProductFollow record);

    ResponseCode addNewProductFollw(NewProductFollow newProductFollow);

    ResponseCode auditNewProductFollow(NewProductFollow newProductFollow);
}
