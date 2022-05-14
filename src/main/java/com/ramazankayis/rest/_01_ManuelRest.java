package com.ramazankayis.rest;



import com.ramazankayis.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _01_ManuelRest {
    //https://jsoneditoronline.org/#left=local.gesomi&right=local.revibe


    //http://localhost:8080/rest1
    @GetMapping("rest1")
    public String getRest1(){

        return "{\n" +
                "  \"adi\":\"Hamit\",\n" +
                "  \"soyadi\":\"Mızrak\"\n" +
                "}";
    }


    //http://localhost:8080/rest2
    @GetMapping("rest2")
    public ProductDto getRest2(){
        ProductDto productDto=ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return productDto;
    }


    //http://localhost:8080/rest3
    //Spring Rest: defaultta Json gelir
    @GetMapping(value = "rest3",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getRest3(){
        ProductDto productDto=ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return productDto;
    }





}
