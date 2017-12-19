package com.yearcon.weixincard.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author itguang
 * @create 2017-12-18 8:18
 **/

@Configuration
public class APPConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }




}
