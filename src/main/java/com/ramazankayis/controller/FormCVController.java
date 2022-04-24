package com.ramazankayis.controller;

import com.ramazankayis.dto.FormCVDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormCVController {


    // Get
    // http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("form_validation_key", new FormCVDto());
        return "formCv";
    }

    // Post
    // http://localhost:8080/form
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("form_validation_key") FormCVDto formCVDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "formCv";
        }
        //database işlemleri için
        //dosya  işlemleri için
        log.info(formCVDto);
        return "success";
    }
}
