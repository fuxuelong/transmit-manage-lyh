package com.qk.transmit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qk.commonservice.baseentity.WorkFlowEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 仓库Entity
 *
 * @author cgg
 * @date 2019/5/27
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Stock extends WorkFlowEntity<Stock> {
    /**
     * 作用
     */
    private String use;
    /**
     * 临时仓库添加时填写的待更新仓库的编码
     */
    private String orderCodes;
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 审批状态
     */
    private String status;
    /**
     * 仓库编码
     */
    private String code;
    /**
     * 仓库名称
     */
    private String name;
    /**
     * 仓库类别
     */
    private String type;
    /**
     * 仓库所有者id，组织机构id
     */
    private String ownerId;
    /**
     * 所有者名称
     */
    private String ownerName;
    /**
     * 所有者编码
     */
    private String ownerCode;
    /**
     * 办事处id
     */
    private String bscId;
    /**
     * 办事处编码
     */
    private String bscCode;
    /**
     * 仓库地址
     */
    private String address;
    /**
     * 所在城市
     */
    private String city;
    /**
     * 临牌终点省份
     */
    private String tempLicenceProvince;
    /**
     * 途经式运转的途经城市
     */
    private String passProvince;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 半径
     */
    private Integer radius;
    /**
     * 负责人
     */
    private String responsible;
    /**
     * 设立日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date buildDate;
    /**
     * 有效状态
     */
    private String active;
    /**
     * 是否可接车
     */
    private String isReceive;
    /**
     * 是否有接车人授权书
     */
    private String isAuthority;
    /**
     * 是否有接车章备案表
     */
    private String isStamp;
    /**
     * 授权书到期日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expireDate;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系人电话
     */
    private String contactTel;
    /**
     * 联系人传真
     */
    private String contactFax;
    /**
     * 联系人邮箱
     */
    private String contactEmail;
    /**
     * 网站
     */
    private String website;
    /**
     * 联系人地址
     */
    private String contactAddress;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 省份证号
     */
    private String idCard;
    /**
     * 区域系数
     */
    private String coefficient;
    /**
     * 授权书
     */
    private String file;
    /**
     * officeId
     */
    private String officeId;

    public Stock() {
    }

    public Stock(String id) {
        this.id = id;
    }

    public Stock(String id, String name) {
        this.id = id;
        this.name = name;
    }

}