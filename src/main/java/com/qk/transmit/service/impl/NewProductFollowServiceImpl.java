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
public class NewProductFollowServiceImpl extends CrudServiceImpl<NewProductFollowDao, NewProductFollow> implements NewProductFollowService{

    @Resource
    private NewProductFollowDao newProductFollowDao;

    /**
     * 删除
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return newProductFollowDao.deleteByPrimaryKey(id);
    }

    /**
     * 添加新产品跟车
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @Override
    public ResponseCode addNewProductFollw(NewProductFollow newProductFollow) {
        int insert = newProductFollowDao.insert(newProductFollow);
        return getResponseCode(insert);
    }

    /**
     * 修改
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @Override
    public ResponseCode updateNewProductFollow(NewProductFollow newProductFollow) {
        //依据id查询修改
        int update = newProductFollowDao.update(newProductFollow);
        return getResponseCode(update);
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
