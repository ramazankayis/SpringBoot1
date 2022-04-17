package com.ramazankayis.controller;

import com.ramazankayis.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//M.V.C
@Controller
public class BeanController {

    @Autowired //inject
    BeanConfig beanConfig;

    // http://localhost:8080
    @GetMapping("/")
    public String root(){
        return "index";
    }

    // http://localhost:8080/bean
    @GetMapping("/bean")
    @ResponseBody
    public String bean(){
        return "Bean: "+beanConfig;
    }
}
