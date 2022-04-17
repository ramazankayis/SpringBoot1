package com.ramazankayis.bean;


import com.ramazankayis.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//BaCı

@Configuration
public class BeanConfig {

    @Bean
    public BeanDto beanDto(){
        BeanDto beanDto=BeanDto
                .builder()
                .beanId(0L)
                .beanName("Bean Name")
                .beanData("Bean data")
                .build();
        return beanDto;
    }
}
