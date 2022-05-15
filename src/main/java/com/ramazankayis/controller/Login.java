package com.ramazankayis.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
public class Login {


    //http://localhost:8080
    //http://localhost:8080/index
    @GetMapping("/index44")
    public String getRoot(){
        return "index";
    }


    //http://localhost:8080/private
    @GetMapping("/private")
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

    //http://localhost:8080/logout
    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request, HttpServletResponse response,Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);

        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            model.addAttribute("key_logout","Çıkış Başarılı");
        }else{
            model.addAttribute("key_logout","Çıkış Başarısız");
        }
        return "/logout";
    }


    //system users
    //http://localhost:8080/user
    @GetMapping("/user")
    @ResponseBody
    public String getUsers(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            log.info(authentication);
            log.info(authentication.hashCode());
            return authentication.getName()+" "+authentication.hashCode();
        }
        return "Sisteme Giriş yapmış kişi bulunmuyor";
    }
}
