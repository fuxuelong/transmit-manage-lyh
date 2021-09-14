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


    /**
     * 添加新产品跟车
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    ResponseCode addNewProductFollw(NewProductFollow newProductFollow);

    /**
     * 修改
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    ResponseCode updateNewProductFollow(NewProductFollow newProductFollow);
}
