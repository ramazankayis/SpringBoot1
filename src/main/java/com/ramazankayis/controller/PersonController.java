package com.ramazankayis.controller;

import com.ramazankayis.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {


    // http://localhost:8080/responsenonhtml
    // bir sayfa olmadan göstermek
    @GetMapping("responsenonhtml")
    @ResponseBody
    public String responseNonHtmlMethod(){
        return "sayfa olmadan gösterildim";
    }

    // http://localhost:8080/other
    @GetMapping("other")
    public String other(){
        return "other/diger";
    }

    // http://localhost:8080/thymeleaf1
    @GetMapping("thymeleaf1")
    public String thymeleaf1(){

        System.out.println("Merhabalar44");
        return "thymeleaf1";
    }

    /////////////////////////////////////////////////
    //Model
    // http://localhost:8080/thymeleaf2
    @GetMapping("thymeleaf2")
    public String thymeleaf2(Model model){
        model.addAttribute("key_text","Ben modelden geldim");
        return "thymeleaf2";
    }

    //messages
    // http://localhost:8080/thymeleaf3
    @GetMapping("thymeleaf3")
    public String thymeleaf3(){
        return "thymeleaf3";
    }


    //object
    // http://localhost:8080/thymeleaf4
    @GetMapping("thymeleaf4")
    public String thymeleaf4(Model model){

        PersonDto personDto=new PersonDto();
        personDto.setPersonId(0L);
        personDto.setPersonName("person name");
        personDto.setPersonSurname("person surname");

        model.addAttribute("key_text",personDto);
        return "thymeleaf4";
    }

}
