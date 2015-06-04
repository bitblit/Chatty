package com.erigir.chatty.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created by chrweiss on 7/12/14.
 */
@Configuration
public class ServiceContext {


//    @Bean
//    public AWSCredentialsProvider awsCredentialsProvider() {
//        return new DefaultAWSCredentialsProviderChain();
//    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper bean = new ObjectMapper();
        bean.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        bean.configure(SerializationFeature.INDENT_OUTPUT, true);
        return bean;
    }

    @Bean
    public Date serverStartTime() {
        return new Date();
    }

}

