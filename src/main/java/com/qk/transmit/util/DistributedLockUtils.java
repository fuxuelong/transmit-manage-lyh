package com.qk.transmit.util;

import com.qk.commonservice.exception.CommonException;
import com.qk.commonservice.exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @date 2020-03-21
 */
public class DistributedLockUtils {
    @Autowired
    private static StringRedisTemplate stringRedisTemplate;

    /**
     * 获取锁
     *
     * @param key         redis中的键
     * @param value       redis中的值
     * @param times       有效时间
     * @param threadLocal threadLocal
     */
    public static void getLock(String key, String value, int times, ThreadLocal<String> threadLocal) {
        // 向redis中更新指定内容，如果成功表示抢到锁，如果没有抢到锁，在10S内不断尝试抢锁，超过10S则不执行
        Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent(key, value,
                times, TimeUnit.SECONDS);
        if (!absent) {
            FutureTask futureTask = new FutureTask<>(() -> {
                while (true) {
                    if (stringRedisTemplate.opsForValue().setIfAbsent(key, value, times, TimeUnit.SECONDS)) {
                        // 退出任务
                        return "true";
                    }
                }
            });
            try {
                // 实例化线程并启动，该线程获得CPU时间后调用futureTask中的run()
                new Thread(futureTask).start();
                // 阻塞主线程10S，超过10S，执行任务的线程会被中断
                Object o = futureTask.get(times, TimeUnit.SECONDS);
            } catch (Exception e) {
                futureTask.cancel(true);
                threadLocal.remove();
                throw new CommonException(ResponseCode.FAIL, "请重新操作");
            }
        }
    }

    /**
     * 给锁续命的线程
     * 每隔10S对redis中设置的锁延长10S的有效期
     *
     * @return 返回线程对象
     */
    public static Thread continuedLifeThread(String key, int times) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true && !Thread.currentThread().isInterrupted()) {
                    try {
                        sleep(times * 1000);
                        System.out.println("--------------------睡眠" + Thread.currentThread().getName() + times + "----------------------------"+ key);
                        stringRedisTemplate.expire(key, times, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        return thread;
    }

    /**
     * 执行结束之后，清空redis和threadLocal中的内容
     */
    public static void removeLock(String key, ThreadLocal<String> threadLocal, Thread thread) {
        System.out.println("----------------删除锁-----------------------------------"+key);
        threadLocal.remove();
        stringRedisTemplate.delete(key);
        // 续命线程中断
        thread.interrupt();
    }

    public static void setRedisTemplate(StringRedisTemplate redisTemplate) {
        stringRedisTemplate = redisTemplate;
    }
}
