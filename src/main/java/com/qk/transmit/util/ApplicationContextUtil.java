package com.qk.transmit.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 同步全媒体平台接口
 *
 * @author fuxuelong
 * @date 2020/11/14
 */
@Configuration
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    //重写setApplicationContext方法，将参数applicationContext赋值给静态类成员
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    //定义get方法，参数为Class，调用上下文中的getBean方法获取容器中的指定对象，
    public static <T> T get(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    //同上，参数为对象名
    public static Object get(String name) {
        return applicationContext.getBean(name);
    }
}
