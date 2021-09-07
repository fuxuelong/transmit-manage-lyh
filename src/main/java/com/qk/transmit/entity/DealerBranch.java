package com.qk.transmit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qk.commonservice.baseentity.WorkFlowEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 经销商网络Entity
 *
 * @author cgg
 * @date 2019/4/3
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class DealerBranch extends WorkFlowEntity<DealerBranch> {
    /**
     * 流程实例id
     */
    private String processInstanceId;
    /**
     * 审批状态
     */
    private String status;
    /**
     * 经销商名称
     */
     private String name;
    /**
     * 办事处id
     */
     private String bscId;
    /**
     * 办事处编码
     */
    private String bscCode;
    /**
     * 办事处名称
     */
    private String bscName;
    /**
     * 经销商简称
     */
    private String shortName;
    /**
     * 经销商编码
     */
    private String code;
    /**
     * 品系
     */
    private String px;
    /**
     * 经营产品，多个以英文逗号分隔
     */
    private String category;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 城市id
     */
    private String cityId;
    /**
     * 城市级别
     */
    private String cityGrade;
    /**
     * 地址
     */
    private String address;
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
     * 经营场所性质，自有、租赁
     */
    private String placeProperty;
    /**
     * 经营场所面积
     */
    private String placeAcreage;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 业务人员总数
     */
    private String salesmanNumber;
    /**
     * 业务负责人
     */
    private String businessLeader;
    /**
     * 业务负责人电话
     */
    private String businessLeaderTel;
    /**
     * 业务负责人传真
     */
    private String businessLeaderFax;
    /**
     * 经销区域
     */
    private String distributeArea;
    /**
     * 承销量
     */
    private String salesVolume;
    /**
     * 有效状态
     */
    private String active;
    /**
     * 变更操作人
     */
    private String modifyOperator;
    /**
     * 变更操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String modifyDate;
    /**
     * 变更备注
     */
    private String modifyRemarks;
    /**
     * 入网时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinDate;
    /**
     * 承销协议书
     */
    private String fileSalesAgreement;
    /**
     * 合作协议书
     */
    private String fileCooperateAgreement;
    /**
     * 新入网单位辅导期工作计划
     */
    private String fileCoachPlan;
    /**
     * 财务报表
     */
    private String fileFinancialStatements;
    /**
     * 公司章程
     */
    private String fileArticles;
    /**
     * 经销单位基本信息表
     */
    private String fileBasicInfo;
    /**
     * 公司人力资源状况表
     */
    private String fileHrInfo;
    /**
     * 网员单位承诺函
     */
    private String fileCommitmentLetter;
    /**
     * 营业执照
     */
    private String fileBusinessLicense;
    /**
     * 银行开户许可证
     */
    private String fileOpenAccountPermit;
    /**
     * 法人及实际负责人身份证复印件
     */
    private String fileIdCardCopy;
    /**
     * 经营场所外景及内部照片
     */
    private String filePlacePicture;
    /**
     * 销服一体证明函
     */
    private String fileSalesServiceProveLetter;
    /**
     * 改装资质证明
     */
    private String fileRfQualify;
    /**
     * 网络审批表
     */
    private String fileApproveForm;
    /**
     * 经销单位评价表
     */
    private String fileEvaluateForm;
    /**
     * 入网开始日期
     */
    private Date joinStartDate;
    /**
     * 入网结束日期
     */
    private Date joinEndDate;


    /**
     * 当前所处流程，0：无，1：保证金比例/金额申请，2：保证金金额划分，3：经营产品变更
     */
    private int onProcess;

    public DealerBranch(){

    }

    public DealerBranch(String id) {
        this.id = id;
    }

}
