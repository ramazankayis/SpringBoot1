package com.ramazankayis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
public class ComputerEntityOrijinal {
////lombok
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//
//
//
////entity
//@Entity
//@Table(name = "computer")
//public class ComputerEntityOrijinal implements Serializable {
//    public static final long serialVersionUID=1L;
//
//   @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//Mysql , H2DB
//    @Column(name="id",updatable = false)
//    private Long computerId;
//
//    @Column(name="computer_name",columnDefinition = "varchar(250) default 'bilgisayar adı girilmedi'")
//    private String computerName;
//
//    // Out of range value for column 'computer_price' at row 1 Decimal(10,2) ==> 10=toplam sayı ,2=virgüllü demek ,
//    //10-2=8  8=tam sayı kısmı 2=virgüllü
//    @Column(name="computer_price",columnDefinition = "Decimal(10,2) default '44'")
//    private double computerPrice;
//
//    //unique: Duplicate entry
//    @Column(name="computer_mac_id",unique = true,nullable = false,length = 300)
//    private String computerMacId;
//
//    //büyük verilerde çalışağım
//    @Lob
//    private String imageEmbedded;
//
//    //sadece javada kullanmak ancak database kaydetmez (unutur)
//    @Transient
//    private int  counter;
//
//    @Column(name="created_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    //@ColumnDefault("CURRENT_TIMESTAMP") //JPA
//    //columnDefinition = "DATE DEFAULT CURRENT_DATE"
//    private Date createdDate;
}




