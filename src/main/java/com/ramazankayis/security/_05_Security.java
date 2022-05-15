package com.ramazankayis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class _05_Security {
  //  @Autowired
   // PasswordEncoder passwordEncoder;
}
//@EnableWebSecurity
//public class _05_Security extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//
//    @Autowired
//    public void ramazanAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception{
//        managerBuilder
//                .inMemoryAuthentication() //cache bellek data olsun
//                .withUser("root")
//                .password(passwordEncoder.encode("root"))
//                .roles("ADMIN");
//    }
//}
