package com.ramazankayis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//exclude:dahil etmemek
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)


//Auditing calismasi icin izin
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringBoot1Application {

    public static void main(String[] args) {

        System.setProperty("spring.devtools.restart.enabled","true");
        System.setProperty("java.awt.headless", "false"); //Disables headless
        SpringApplication.run(SpringBoot1Application.class, args);
    }

}
