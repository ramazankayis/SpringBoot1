package com.ramazankayis.bean;


import com.ramazankayis.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//BaCı

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod")
//  @Scope("request")
//  @Scope("singleton") //default

//   @Scope("session")
//   @Scope("prototype")
    public BeanDto beanDto(){
//        BeanDto beanDto=BeanDto
//                .builder()
//                    .beanId(0L)
//                    .beanName("Bean Name44")
//                    .beanData("Bean data44")
//                .build();
        BeanDto beanDto=new BeanDto();
        beanDto.setBeanId(0L);
        beanDto.setBeanName("Bean Name44");
        beanDto.setBeanData("Bean data44");
        return beanDto;
    }
}
