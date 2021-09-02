package com.qk.transmit.util;

import com.qk.commonservice.commonutil.StringUtils;
import com.qk.commonservice.dao.CrudDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 *
 * @author fuxuelong
 * @date 2020/7/8
 */
public class TransUtils {
    @Value("${isTest}")
    private static boolean isTest;

    /**
     * 创建编码
     *
     * @param code 初始编码
     * @return 编码
     */
    public static String createCode(String code, CrudDao crudDao) {
        String maxCode = crudDao.getMaxCode(code);
        if (StringUtils.isBlank(maxCode)) {
            code = code + "001";
        } else {
            int no = Integer.parseInt(maxCode.substring(maxCode.length() - 3)) + 1;
            String formatNo = String.format("%03d", no);
            code = code + formatNo;
        }
        return code;
    }

    /**
     * 获取当时时间，
     *
     * @param date    时间
     * @param pattern 格式yyyy-dd-MM HH:mm:ss
     * @return truck
     */
    public static String getFormatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 获取bootstrap中的配置（可用于静态类中）
     *
     * @param name 名称
     * @return truck
     */
    public static String getProperty(String name) {
        Environment environment = ApplicationContextUtil.get(Environment.class);
        String property = environment.getProperty(name);
        return property;
    }

    /**
     * 如果字符串为空，返回默认字符串
     *
     * @param str 字符串
     */
    public static String returnDefaultStr(Object str, String defaultStr) {
        return (str == null || StringUtils.isBlank(str.toString())) ? defaultStr : str.toString();
    }
}

