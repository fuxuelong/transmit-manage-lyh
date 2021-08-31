package com.qk.transmit.config;

import com.qk.commonservice.commonutil.DictUtils;
import com.qk.commonservice.commonutil.UserUtils;
import com.qk.transmit.util.DistributedLockUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @date 2018/9/10
 */
@Component
public class InitClass implements InitializingBean {
    @Autowired
    @Qualifier("redisTemplateBean")
    private RedisTemplate<Object, Object> redisTemplateBean;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void afterPropertiesSet() {
        UserUtils.setRedisTemplateBean(redisTemplateBean);
        DictUtils.setRedisTemplateBean(redisTemplateBean);
        DistributedLockUtils.setRedisTemplate(stringRedisTemplate);
    }
}
