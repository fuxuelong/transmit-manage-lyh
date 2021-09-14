package com.qk.transmit.service.impl;

import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.service.impl.CrudServiceImpl;
import com.qk.transmit.dao.MoveStockApplyDao;
import com.qk.transmit.entity.MoveStockApply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.qk.transmit.dao.NewProductFollowDao;
import com.qk.transmit.entity.NewProductFollow;
import com.qk.transmit.service.NewProductFollowService;

@Service
public class NewProductFollowServiceImpl extends CrudServiceImpl<NewProductFollowDao, NewProductFollow> implements NewProductFollowService {

    @Resource
    private NewProductFollowDao newProductFollowDao;

    /**
     * 添加新产品跟车
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @Override
    public ResponseCode addNewProductFollw(NewProductFollow newProductFollow) {
        int count = save(newProductFollow);
        return getResponseCode(count);
    }

    /**
     * 修改
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @Override
    public ResponseCode updateNewProductFollow(NewProductFollow newProductFollow) {
        int count = save(newProductFollow);
        return getResponseCode(count);
    }

    /**
     * 核对是否执行成功
     *
     * @param check SQL执行返回值
     * @return 返回结果
     */
    private ResponseCode getResponseCode(int check) {
        if (check > 0) {
            return ResponseCode.OK;
        } else {
            return ResponseCode.FAIL;
        }
    }
}
