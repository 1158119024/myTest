package com.xiaofeng.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean
    public MyHealthIndicator myHealthIndicator(){
        return new MyHealthIndicator();
    }
}
