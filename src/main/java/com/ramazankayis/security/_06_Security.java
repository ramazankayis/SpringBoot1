package com.ramazankayis.security;


public class _06_Security {

}

//@EnableWebSecurity
//public class _06_Security extends WebSecurityConfigurerAdapter {
//   // @Autowired
//    //PasswordEncoder passwordEncoder;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       http
//               .authorizeRequests()
//               .antMatchers("/","/index","/success","/login")
//               .permitAll()
//               .anyRequest()
//               .authenticated();
//    }
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
