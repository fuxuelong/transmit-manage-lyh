package com.qk.transmit.config;

import com.qk.commonservice.commonutil.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author zhangyu
 * @date 2018/7/14
 */
@Configuration
@EnableResourceServer
@RefreshScope
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${ignoreURL}")
    private String ignoreURL;
    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        if (StringUtils.isNotBlank(ignoreURL)){
            String[] ignoreURLArray = ignoreURL.split(",");
            for (String url : ignoreURLArray) {
                http.authorizeRequests().antMatchers(url).permitAll();
            }
        }
        http.authorizeRequests().antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(applicationName).tokenStore(tokenStore);
    }
}
