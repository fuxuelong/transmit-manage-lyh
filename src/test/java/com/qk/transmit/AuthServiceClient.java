package com.qk.transmit;

import com.qk.commonservice.baseentity.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangyu
 * @date 2018/7/14
 */
@Component
@FeignClient(value = "uaa-server")
public interface AuthServiceClient {
    /**
     * 获取token
     *
     * @param authorization
     * @param type
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/oauth/token")
    JWT getToken(
            @RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
            @RequestParam("username") String username,
            @RequestParam("password") String password);
}
