package com.qk.transmit.util;

/**
 * 静态参数实体类
 *
 * @author fuxuelong
 * @date 2021/5/8
 */
public class TransConstant {

    /**************移库信息申请状态字典****************/
    //销管驳回
    public static final Integer MOVE_STOCK_APPLY_STATUS_XG_REJECT = -10;
    //办事处驳回
    public static final Integer MOVE_STOCK_APPLY_STATUS_BSC_REJECT = -5;
    //提交
    public static final Integer MOVE_STOCK_APPLY_STATUS_SUBMIT = 0;
    //办事处审批通过
    public static final Integer MOVE_STOCK_APPLY_STATUS_BSC_PASS = 5;
    //销管审批通过
    public static final Integer MOVE_STOCK_APPLY_STATUS_XG_PASS = 10;
    //经销商接收
    public static final Integer MOVE_STOCK_APPLY_STATUS_RECEIVED = 15;
    /*************是、否、对、错****************/
    public static String YES = "1";
    public static String NO = "0";
    public static String TRUE = "true";
    public static String FALSE = "false";
    /**************加油信息申请状态字典****************/
    public static Integer OIL_APPLY_STATUS_REJECT = -10;
    public static Integer OIL_APPLY_STATUS_SUBMIT = 5;
    public static Integer OIL_APPLY_STATUS_PASS = 10;
    /**************智能通接口路径****************/
    //推送运转单
    public static String ZNT_URL_TRANSMITBILL = "https://www.sinotruksfs.com/dmsjk/dmsjkmain2.aspx";
    //运转单取消
    public static String ZNT_URL_TRANSMITBILL_CANCEL = "https://www.sinotruksfs.com/dmsjk/dmsjkmain2.aspx";
    //推送送车公司
    public static String ZNT_URL_TRANSPORT = "https://www.sinotruksfs.com/dmsjk/dmsjkmain.aspx";
    //存放点增删改
    public static String ZNT_URL_STOCK = "https://www.sinotruksfs.com/dmsjk/dmsjkmain2.aspx";
    //司机
    public static String ZNT_URL_DRIVER = "https://www.sinotruksfs.com/dmsjk/dmsjkmain.aspx";
    /**************智能通接口sign****************/
    public static String ZNT_SIGN = "111";
    /**************推送失败数据的类型****************/
    public static String FAULT_DATA_TYPE_INSURE = "保险数据";
    public static String FAULT_DATA_TYPE_TRANSMITBILL = "运转单";
    public static String FAULT_DATA_TYPE_TRANSPORT = "送车公司";
    public static String FAULT_DATA_TYPE_TRANSMIT_CANCEL = "废除运转单";
    public static String FAULT_DATA_TYPE_STOCK = "接车点";
    public static String FAULT_DATA_TYPE_DRIVER = "送车司机";
}
