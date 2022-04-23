package com.ramazankayis.controller;

import com.ramazankayis.dto.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

        //parametresiz
        PersonDto personDto=new PersonDto();
        personDto.setPersonId(0L);
        personDto.setPersonName("person name");
        personDto.setPersonSurname("person surname");
        model.addAttribute("key_text",personDto);
        return "thymeleaf4";
    }

    //object
    // http://localhost:8080/thymeleaf5
    @GetMapping("thymeleaf5")
    public String thymeleaf5(Model model){
        List<PersonDto> personDtoList=new ArrayList<>();
        personDtoList.add(new PersonDto(1L,"personadi1","personsoyadi1"));
        personDtoList.add(new PersonDto(2L,"personadi2","personsoyadi2"));
        personDtoList.add(new PersonDto(3L,"personadi3","personsoyadi3"));
        personDtoList.add(new PersonDto(4L,"personadi4","personsoyadi4"));
        personDtoList.add(new PersonDto(5L,"personadi5","personsoyadi5"));
        model.addAttribute( "key_list",   personDtoList);
        return "thymeleaf5";
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //PathVariable-1
    // http://localhost:8080/thymeleaf6/44
    @GetMapping("thymeleaf6/{id}")
    public String thymeleaf6(@PathVariable(name = "id") Long id, Model model) {
        PersonDto personDto = PersonDto
                .builder()
                .personId(id)
                .personName("adı44")
                .personSurname("soyadı44")
                .build();
        model.addAttribute("key_text", personDto);
        return "thymeleaf6";
    }


    //PathVariable-2
    // http://localhost:8080/thymeleaf7/44
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String thymeleaf7(@PathVariable(name = "id", required = false) Long id, Model model) {
        PersonDto personDto = PersonDto
                .builder()
                .personId(id)
                .personName("adı")
                .personSurname("soyadı")
                .build();
        model.addAttribute("key_text", personDto);
        return "thymeleaf7";
    }

    //PathVariable-3
    // http://localhost:8080/thymeleaf8/44
    @GetMapping({"/thymeleaf8", "/thymeleaf8/{id}"})
    public String thymeleaf8(@PathVariable(name = "id", required = false) Long id, Model model) {

        if (id == null) {
            model.addAttribute("key_text", "id girmediniz");
        } else if (id == 0L) {
            model.addAttribute("key_text", "sıfır girildi");
        } else {
            PersonDto personDto = PersonDto
                    .builder()
                    .personId(id)
                    .personName("adı")
                    .personSurname("soyadı")
                    .build();
            model.addAttribute("key_text", personDto);
        }
        return "thymeleaf8";
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //RequestParam-1
    // http://localhost:8080/thymeleaf9?id=55
    @GetMapping("thymeleaf9")
    public String thymeleaf9(@RequestParam(name = "id") Long id, Model model) {
        PersonDto personDto = PersonDto
                .builder()
                .personId(id)
                .personName("adı44")
                .personSurname("soyadı44")
                .build();
        model.addAttribute("key_text", personDto);
        return "thymeleaf9";
    }

    //RequestParam-2
    // http://localhost:8080/thymeleaf10?adi=Hamit&soyadi=Mızrak
    @GetMapping("thymeleaf10")
    public String thymeleaf10(

            @RequestParam(name = "adi") String adi,
            @RequestParam(name = "soyadi") String soyadi,
            Model model
    ) {
        PersonDto personDto = PersonDto
                .builder()
                .personId(4L)
                .personName(adi)
                .personSurname(soyadi)
                .build();
        model.addAttribute("key_text", personDto);
        return "thymeleaf10";
    }

    //RequestParam-3
    // http://localhost:8080/thymeleaf11/44?adi=Hamit&soyadi=Mızrak
    @GetMapping("thymeleaf11/{id}")
    public String thymeleaf11(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "adi") String adi,
            @RequestParam(name = "soyadi") String soyadi,
            Model model
    ) {
        PersonDto personDto = PersonDto
                .builder()
                .personId(id)
                .personName(adi)
                .personSurname(soyadi)
                .build();
        model.addAttribute("key_text", personDto);
        return "thymeleaf11";
    }


    //RequestParam-4
    // http://localhost:8080/thymeleaf12?adi=Hamit&soyadi=Mızrak
    // http://localhost:8080/thymeleaf12/55?adi=Hamit&soyadi=Mızrak
    @GetMapping({"thymeleaf12","thymeleaf12/{id}"})
    public String thymeleaf12(
            @PathVariable(name = "id",required = false) Long id,
            @RequestParam(name = "adi") String adi,
            @RequestParam(name = "soyadi") String soyadi,
            Model model
    ) {
        if(id==null || id==0L){
            model.addAttribute("key_text", "id sıfır veya girilmedi");
        }else{
            PersonDto personDto = PersonDto
                    .builder()
                    .personId(id)
                    .personName(adi)
                    .personSurname(soyadi)
                    .build();
            model.addAttribute("key_text", personDto);
        }
        return "thymeleaf12";
    }



}
