package com.qk.transmit.entity;

import com.qk.commonservice.baseentity.WorkFlowEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 加油信息修改申请
 *
 * @author fxl
 * @date 2021/5/8
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class OilApply extends WorkFlowEntity<OilApply> {
    /**
     * 加油站编码
     */
    private String transportCompanyCode;
    /**
     * 加油站名称
     */
    private String transportCompanyName;
    /**
     * 送车里程id
     */
    private String mileageId;
    /**
     * code
     */
    private String code;
    /**
     * 审批状态
     */
    private Integer status;
    /**
     * process_instance_id
     */
    private String processInstanceId;
    /**
     * 运转单号
     */
    private String yzdh;
    /**
     * 类型
     */
    private String type;
    /**
     * 开始城市
     */
    private String startCity;
    /**
     * 结束城市
     */
    private String endCity;
    /**
     * 加油量
     */
    private String oilQuantity;
    /**
     * 加油编号
     */
    private String octaneRating;
    /**
     * officeId
     */
    private String officeId;
}
