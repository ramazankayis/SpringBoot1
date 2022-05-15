package com.ramazankayis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {


    //http://localhost:8080
    //http://localhost:8080/index
    @GetMapping("/index44")
    public String getRoot(){
        return "index";
    }


    //http://localhost:8080/admin44
    @GetMapping("/admin44")
    public String getAdminIndex(){
        return "admin";
    }


    //http://localhost:8080/login
    //http://localhost:8080/login?error
    //http://localhost:8080/register
    @GetMapping("/register")
    public String register(@RequestParam(value="error",required = false) String error, Model model){
        if(error!=null){
            model.addAttribute("key_register","Kullanıcı adı veya Şifre yanlıştır");
        }else{
            model.addAttribute("key_register","Lütfen bilgilerinizi giriniz");
        }
        return "register";
    }
}
