package com.qk.transmit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qk.commonservice.baseentity.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 车辆状态历史记录Entity
 *
 * @author cgg
 * @date 2019/5/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TruckHistory extends DataEntity<TruckHistory> {
    /**
     * 车辆表ID
     */
    private String truckId;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 销售单号
     */
    private String salesBillCode;
    /**
     * 车架号
     */
    private String cjh;
    /**
     * 经销商网络编码
     */
    private String dealerBranchCode;
    /**
     * 车辆状态（当前）
     */
    private String status;
    /**
     * 仓库名字
     */
    private String stockName;
    /**
     * 状态变化时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operateDate;
    /**
     * 操作人名称
     */
    private String operator;

    public TruckHistory(String truckId,
                        String orderCode,
                        String salesBillCode,
                        String cjh,
                        String dealerBranchCode,
                        String status,
                        String stockName,
                        Date operateDate,
                        String operator,
                        String remarks) {
        this.truckId = truckId;
        this.orderCode = orderCode;
        this.salesBillCode = salesBillCode;
        this.cjh = cjh;
        this.dealerBranchCode = dealerBranchCode;
        this.status = status;
        this.stockName = stockName;
        this.operateDate = operateDate;
        this.operator = operator;
        this.remarks = remarks;
    }

}