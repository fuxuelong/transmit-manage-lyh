package com.qk.transmit.web;

import com.github.pagehelper.PageInfo;
import com.qk.commonservice.commonutil.StringUtils;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.sysentity.ResponseJson;
import com.qk.transmit.entity.NewProductFollow;
import com.qk.transmit.service.NewProductFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 新产品跟车
 *
 * @author lyh
 * @date 2021/9/13
 */
@RestController
@RequestMapping("/newProductFollow")
public class NewProductFollowController {

    @Autowired
    private NewProductFollowService newProductFollowServiceImpl;

    /**
     * 查询新产品跟车列表
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 将得到的数据以List集合对象形式返回
     */
    @PostMapping("/getNewProductFollowList")
    public PageInfo<NewProductFollow> getCheckList(@RequestBody NewProductFollow newProductFollow) {
        return newProductFollowServiceImpl.findPage(newProductFollow);
    }

    /**
     * 添加新产品跟车
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @PostMapping("/addNewProductFollow")
    public ResponseJson saveCheck(@RequestBody NewProductFollow newProductFollow) {
        checkParam(newProductFollow);
        ResponseCode code = newProductFollowServiceImpl.addNewProductFollw(newProductFollow);
        return new ResponseJson(code);
    }

    /**
     * 修改
     *
     * @param newProductFollow 新产品跟车实体对象
     * @return 返回结果
     */
    @PostMapping("/updateNewProductFollow")
    public ResponseJson auditMoveStockApply(@RequestBody NewProductFollow newProductFollow) {
        Object[] strArray = {
                newProductFollow.getCjh(), newProductFollow.getCxh(),
                newProductFollow.getEngineType(), newProductFollow.getCarType()
        };
        if (!StringUtils.isAllNotBlank(strArray)) {
            return new ResponseJson(ResponseCode.FAIL, "必传字段为空");
        }
        ResponseCode code = newProductFollowServiceImpl.updateNewProductFollow(newProductFollow);
        return new ResponseJson(code);
    }

    /**
     * 删除
     *
     * @param id id
     * @return 返回结果
     */
    @PostMapping("/deleteNewProductFollow")
    public ResponseJson delete(@RequestParam String id) {
        int delete = newProductFollowServiceImpl.deleteByPrimaryKey(Integer.parseInt(id));
        ResponseCode code;
        if (delete > 0) {
            code= ResponseCode.OK;
        } else {
            code= ResponseCode.FAIL;
        }
        return new ResponseJson(code);
    }



    /**
     * 校验必传参数
     *
     * @param newProductFollow 新产品跟车实体对象
     */
    private void checkParam(@RequestBody NewProductFollow newProductFollow) {
        if (StringUtils.isBlank(newProductFollow.getCjh())) {
            throw new CommonException(ResponseCode.FAIL, "车架号必传");
        }
        if (StringUtils.isBlank(newProductFollow.getCxh())) {
            throw new CommonException(ResponseCode.FAIL, "车型号必传");
        }
        if (StringUtils.isBlank(newProductFollow.getEngineType())) {
            throw new CommonException(ResponseCode.FAIL, "发动机型号必传");
        }
        if (StringUtils.isBlank(newProductFollow.getCarType())) {
            throw new CommonException(ResponseCode.FAIL, "上装类型必传");
        }
    }

}
