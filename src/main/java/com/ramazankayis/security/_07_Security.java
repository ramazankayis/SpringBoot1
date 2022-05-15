package com.ramazankayis.security;


import com.ramazankayis.bean.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//CSRF:Cross Site Request Forgency (Web siteler arasında istek Sahteciliği)
@EnableWebSecurity
public class _07_Security extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordBean passwordBean;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/register","/user").permitAll()
                .antMatchers("/logout").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/register")
                .and()
                .logout().logoutUrl("/logout").invalidateHttpSession(true)
                .permitAll();

    }


    @Autowired
    public void configureGlobalAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .inMemoryAuthentication()
                .withUser("hamitmizrak")
                .password(passwordBean.passwordEncoder().encode("root"))
                .roles("ADMIN_44");
    }

}

