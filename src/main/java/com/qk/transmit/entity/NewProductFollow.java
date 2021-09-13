package com.qk.transmit.entity;

import java.util.Date;

import com.qk.commonservice.baseentity.WorkFlowEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新产品跟车
 *
 * @author lyh
 * @date 2021/9/13
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class NewProductFollow extends WorkFlowEntity<NewProductFollow> {

    /**
    * 车架号
    */
    private String cjh;

    /**
    * 车型号
    */
    private String cxh;

    /**
    * 发动机型号
    */
    private String engineType;

    /**
    * 行驶里程
    */
    private Double driveKilometer;

    /**
    * 货物类型
    */
    private String goodsType;

    /**
    * 载货吨位
    */
    private Integer goodsTonnage;

    /**
    * 跟车运距
    */
    private Double followKilometer;

    /**
    * 上装类型
    */
    private String carType;

    /**
    * 发动机怠速转速
    */
    private Integer engineIdleSpeed;

    /**
    * 发动机空高转速
    */
    private Integer engineEmptyIdleHighspeed;

    /**
    * 空载最高档最高车速（Km/h）
    */
    private Integer emptyTopGearMaxspeed;

    /**
    * 空载次高档最高车速（Km/h）
    */
    private Integer emptySecondaryGearMaxspeed;

    /**
    * 空载次高档最高车速对应转速（r/min）
    */
    private Integer emptySecondaryGearMaxspeedRotation;

    /**
    * 空载平均油耗（L/100km）
    */
    private Double emptyAverageFuelConsumption;

    /**
    * 载货最高档最高车速（Km/h）
    */
    private Integer carryTopGearMaxspeed;

    /**
    * 载货最高车速对应转速（r/min）
    */
    private Integer carryMaxspeedRotation;

    /**
    * 载货平均油耗（L/100km）
    */
    private Double carryAverageFuelSonsumption;

    /**
    * 用户描述的目前存在问题
    */
    private String userComplaint;

    /**
    * 问题解决进度
    */
    private String problemSolveProgress;

    /**
    * 用户评价
    */
    private String userEvaluation;

    /**
    * 用户建议
    */
    private String userSuggestion;

    /**
    * 经销商组织结构
    */
    private Integer officeId;

    /**
    * 创建者名字
    */
    private String createName;

}