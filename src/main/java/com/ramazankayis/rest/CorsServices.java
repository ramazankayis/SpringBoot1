package com.ramazankayis.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsServices {
    //http://localhost:8080/cros
    @GetMapping("/cros")
    public String message(){

        return "merhabalar Cors dünyası";
    }
}
