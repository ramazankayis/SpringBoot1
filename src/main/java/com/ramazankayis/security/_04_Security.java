package com.ramazankayis.security;


public class _04_Security {

}

//
//@EnableWebSecurity
//public class _04_Security extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    public void ramazanAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception{
//        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        managerBuilder
//                .inMemoryAuthentication() //cache bellek data olsun
//                .withUser("root")
//                .password(passwordEncoder.encode("root"))
//                .roles("ADMIN");
//    }
//}
