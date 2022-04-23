package com.ramazankayis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormCVDto {

    private Long registerId;

    @NotEmpty(message="Adı veya soyadını boş geçemezsiniz")
    private String registerNameAndSurname;

    @NotEmpty(message="Şifre boş geçemezsiniz")
    private String registerPassword;

    @NotEmpty(message="Email boş geçemezsiniz")
    @Email(message = "uygun formatta email girmediniz. exam: xyz@deneme.com")
    private String registerEmail;

    @NotEmpty(message="yaş boş geçemezsiniz")
    @Min(message = "18 yaş altı olamaz",value = 18)
    @Max(message = "55 yaş altı üstü olamaz",value = 55)
    private int registerAge;


    public String creationDate=getNowDate();

    private String getNowDate() {
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss",locale);
        Date date=new Date(System.currentTimeMillis());
        String formatCast=simpleDateFormat.format(date);
        return formatCast;
    }

    public static void main(String[] args) {
        //FormCVDto dto=new FormCVDto();
        //System.out.println( dto.getNowDate());
    }
}