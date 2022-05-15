package com.ramazankayis.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthenticationPage {

    //http://localhost:8080
    //http://localhost:8080/index
    @GetMapping("/index")
    public String getRoot(){
        return "index";
    }

    //http://localhost:8080/admin
    @GetMapping("/admin")
    public String getAdminIndex(){
        return "admin";
    }


}
