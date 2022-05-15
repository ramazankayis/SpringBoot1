package com.ramazankayis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
public class _03_Security{

}

//@EnableWebSecurity
//public class _03_Security extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    public void ramazanAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception{
//        managerBuilder
//                .inMemoryAuthentication() //cache bellek data olsun
//                .withUser("ramazan")
//                .password("{noop}root")
//                .roles("ADMIN");
//    }
//}
