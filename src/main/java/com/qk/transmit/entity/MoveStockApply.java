package com.qk.transmit.entity;
import com.alibaba.druid.sql.visitor.functions.Char;
import com.qk.commonservice.baseentity.WorkFlowEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 移库申请
 *
 * @author lyh
 * @date 2021/9/1
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class MoveStockApply extends WorkFlowEntity<MoveStockApply> {

    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * 审批状态(-10、0、5、10、15)
     */
    private Integer status;

    /**
     * 车架号
     */
    private String cjh;

    /**
     * 原仓库id
     */
    private Integer startStockId;

    /**
     * 原仓库编码
     */
    private String startStockCode;

    /**
     * 原仓库名称
     */
    private String startStockName;

    /**
     * 新仓库id
     */
    private Integer endStockId;

    /**
     * 新仓库编码
     */
    private String endStockCode;

    /**
     * 新仓库名称
     */
    private String endStockName;

    /**
     * 移库原因
     */
    private String reason;

    /**
     * 审批完成时间(通过或驳回）（办事处或销管操作）
     */
    private Date auditDate;

    /**
     * 经销商接车时间
     */
    private Date receiveDate;

    /**
     * 第几次移库（超过五次需要销管审核）
     */
    private Integer times;

    /**
     * 经销商组织结构
     */
    private String officeId;  //数据库中对应为int型

    /**
     * 创建者名字
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

}
