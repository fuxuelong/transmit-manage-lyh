package com.qk.transmit;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 运转管理启动类
 *
 * @author cgg
 * @date 2019/5/23
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RefreshScope
@ComponentScan("com.qk.*")
@MapperScan("com.qk.*")
@EnableTransactionManagement
@EnableDistributedTransaction
public class TransmitManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransmitManageApplication.class, args);
    }
}

