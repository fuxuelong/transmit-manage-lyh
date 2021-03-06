package com.qk.transmit.web;

import com.github.pagehelper.PageInfo;
import com.qk.commonservice.commonutil.StringUtils;
import com.qk.commonservice.commonutil.UserUtils;
import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ResponseCode;
import com.qk.commonservice.sysentity.ResponseJson;
import com.qk.transmit.entity.MoveStockApply;
import com.qk.transmit.service.MoveStockApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moveStockApply")
public class MoveStockApplyController {

    @Autowired
    private MoveStockApplyService moveStockApplyServiceImpl;

    /**
     * 查询移库申请列表
     *
     * @param moveStockApply 移库实体对象
     * @return 将得到的数据以List集合对象形式返回
     */
    @PostMapping("/getMoveStockApplyList")
    public PageInfo<MoveStockApply> getCheckList(@RequestBody MoveStockApply moveStockApply) {
        return moveStockApplyServiceImpl.findPageFilter(moveStockApply, UserUtils.getUser(), "a");
    }

    /**
     * get移库申请
     *
     * @param id id
     * @return 将得到的数据以List集合对象形式返回
     */
    @PostMapping("/getMoveStockApply")
    public MoveStockApply getMoveStockApply(@RequestParam String id) {
        return moveStockApplyServiceImpl.get(id);
    }

    /**
     * 添加
     *
     * @param moveStockApply 移库实体对象
     * @return 返回结果
     */
    @PostMapping("/addMoveStockApply")
    public ResponseJson saveCheck(@RequestBody MoveStockApply moveStockApply) {
        checkParam(moveStockApply);
        ResponseCode code = moveStockApplyServiceImpl.addMoveStockApply(moveStockApply);
        return new ResponseJson(code);
    }

    /**
     * 修改
     *
     * @param moveStockApply 移库实体对象
     *                       return 返回结果
     */
    @PostMapping("/auditMoveStockApply")
    public ResponseJson auditMoveStockApply(@RequestBody MoveStockApply moveStockApply) {
        Object[] strArray = {
                moveStockApply.getId(), moveStockApply.getWorkFlow().getFlag(),
                moveStockApply.getWorkFlow().getProcInsId(), moveStockApply.getWorkFlow().getTaskId(),
                moveStockApply.getWorkFlow().getTaskDefKey()
        };
        if (!StringUtils.isAllNotBlank(strArray)) {
            return new ResponseJson(ResponseCode.FAIL, "必传字段为空");
        }
        ResponseCode code = moveStockApplyServiceImpl.auditMoveStockApply(moveStockApply);
        return new ResponseJson(code);
    }

    /**
     * 校验必传参数
     *
     * @param moveStockApply 移库实体对象
     */
    private void checkParam(@RequestBody MoveStockApply moveStockApply) {
        if (StringUtils.isBlank(moveStockApply.getCjh())) {
            throw new CommonException(ResponseCode.FAIL, "车架号必传");
        }
        if (moveStockApply.getEndStockId() == null) {
            throw new CommonException(ResponseCode.FAIL, "目的仓库id必传");
        }
        if (StringUtils.isBlank(moveStockApply.getEndStockCode())) {
            throw new CommonException(ResponseCode.FAIL, "目的仓库编码必传");
        }
        if (StringUtils.isBlank(moveStockApply.getEndStockName())) {
            throw new CommonException(ResponseCode.FAIL, "目的仓库名称必传");
        }
    }

    /**
     * 删除
     *
     * @param id id
     * @return 返回结果
     */
    @PostMapping("/deleteMoveStockApply")
    public ResponseJson delete(@RequestParam String id) {
        moveStockApplyServiceImpl.delete(id);
        return new ResponseJson(ResponseCode.OK);
    }

}
