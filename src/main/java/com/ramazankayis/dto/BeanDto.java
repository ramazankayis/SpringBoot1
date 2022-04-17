package com.ramazankayis.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

//lombok
@Data
@Log4j2
public class BeanDto {
    private Long beanId=0L;
    private String beanName="bean name";
    private String beanData="bean data";


    //başlangıç
    public void initialBeanMethod(){
        log.error("bean başladı");
        System.out.println("bean başladı");
    }

    //bitiş
    public void destroyBeanMethod(){
        log.error("bean bitti");
        System.out.println("bean bitti");
    }

    /////////////////////////////////////////
    //constructor
//    @Autowired
//    Logger logger;
//
//
//    @PostConstruct
//    public void init(){
//        logger.info("Loglama constructor");
//    }
//
//    public static void main(String[] args) {
//        BeanDto beanDto=new BeanDto();
//        System.out.println(beanDto);
//    }
}