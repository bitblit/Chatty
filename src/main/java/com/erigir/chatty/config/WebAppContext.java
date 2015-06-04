package com.erigir.chatty.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chrweiss on 7/12/14.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.erigir.chatty.ctrl"
})
@Import({ServiceContext.class})
@EnableWebMvc
public class WebAppContext extends WebMvcConfigurerAdapter {


}
