package com.ramazankayis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BeanDto {
    private Long beanId;
    private String beanName;
    private String beanData;
}
