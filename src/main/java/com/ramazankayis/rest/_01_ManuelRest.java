package com.ramazankayis.rest;



import com.ramazankayis.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class _01_ManuelRest {
    //https://jsoneditoronline.org/#left=local.gesomi&right=local.revibe


    //http://localhost:8080/rest1
    @GetMapping("rest1")
    public String getRest1() {

        return "{\n" +
                "  \"adi\":\"Hamit\",\n" +
                "  \"soyadi\":\"Mızrak\"\n" +
                "}";
    }


    //http://localhost:8080/rest2
    @GetMapping("rest2")
    public ProductDto getRest2() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return productDto;
    }


    //http://localhost:8080/rest3
    //Spring Rest: defaultta Json gelir
    @GetMapping(value = "rest3", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getRest3() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return productDto;
    }


    //http://localhost:8080/rest4/2
    //http://localhost:8080/rest4
    @GetMapping({"rest4", "rest4/{id}"})
    public ProductDto getRest4(@PathVariable(name = "id", required = false) Long id) {
        ProductDto productDto = null;
        if (id == null) {
            log.error("id Null geldi");
        } else {
            productDto = ProductDto
                    .builder()
                    .productId(id)
                    .productName("Ürün Adı44")
                    .productTrade("ürün markası44")
                    .build();
        }
        return productDto;
    }


    //http://localhost:8080/rest5
    @GetMapping("rest5")
    public List<ProductDto> getRest5() {
        List<ProductDto> listem = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listem.add(ProductDto.builder().productId(Long.valueOf(i)).productName("name: " + i).productTrade("Trade: " + i).build());
        }
        /*for(ProductDto temp :listem){
            System.out.println(temp);
        }*/
        return listem;
    }

    ////////////////////////////////////////////////
    //ResponseEntity
    //http://localhost:8080/rest6
    @GetMapping("rest6")
    public ResponseEntity<ProductDto> getRest6() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //http://localhost:8080/rest7
    @GetMapping("rest7")
    public ResponseEntity<ProductDto> getRest7() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }


    //http://localhost:8080/rest8
    @GetMapping("rest8")
    public ResponseEntity<ProductDto> getRest8() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(1L)
                .productName("Ürün Adı")
                .productTrade("ürün markası")
                .build();
        return ResponseEntity.ok().body(productDto);
    }

    //http://localhost:8080/rest9/4
    //http://localhost:8080/rest9/0
    //http://localhost:8080/rest9
    @GetMapping({"rest9", "rest9/{id}"})
    public ResponseEntity<?> getRest9(@PathVariable(name = "id", required = false) Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Ürün Adı").productTrade("ürün markası").build();
        if (productDto.getProductId() == null) {////Error:404 (Client)
            log.error("Kayıt Bulunamadı !!!!!!");
            //return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt Bulunamadı");
            return ResponseEntity.notFound().build();
        } else if (productDto.getProductId() == 0) { //Error:400 (Client)
            return ResponseEntity.badRequest().build();
        }
        log.info(productDto);
        return ResponseEntity.ok(productDto);
    }


}
