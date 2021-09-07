package com.qk.transmit.entity;

import com.qk.commonservice.baseentity.DataEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 车辆对象
 *
 * @author cgg
 * @date 2019/5/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trucks extends DataEntity<Trucks> {
    /**
     * 销售单号
     */
    private String salesBillCode;
    /**
     * 销售单id
     */
    private String salesBillId;
    /**
     * 原销售单号
     */
    private String oldSaleBillCode;
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 车辆状态
     */
    private String status;
    /**
     * 仓库
     */
    private Stock stock;
    /**
     * 车架号
     */
    private String cjh;
    /**
     * 发动机号
     */
    private String engineCode;
    /**
     * 是否订车
     */
    private String isBook;
    /**
     * 订车时间
     */
    private Date bookDate;
    /**
     * 取消订车时间
     */
    private Date cancelBookDate;
    /**
     * 销售状态
     */
    private String salesStatus;
    /**
     * 经销商网络
     */
    private DealerBranch dealerBranch;
    /**
     * 结算标记
     */
    private String settlementFlag;
    /**
     * 结算时间
     */
    private Date settlementDate;
    /**
     * 共享类别
     */
    private String shareType;
    /**
     * 业务模式
     */
    private String businessMode;
    /**
     * 车辆价格
     */
    private Double price;
    /**
     * 初始订单号
     */
    private String originalOrderCode;
    /**
     * 合格证邮寄状态
     */
    private String hgzPostStatus;
    /**
     * vin（从生产数据库获取）
     */
    private String vin;
    /**
     * 合格证车型号
     */
    private String certificateName;

}