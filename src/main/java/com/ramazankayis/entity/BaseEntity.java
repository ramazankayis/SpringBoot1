package com.ramazankayis.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

//lombok
@Getter
@Setter

//super class
@MappedSuperclass

//Auditing icin
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;

    //system_current_time
    @Column(name = "system_created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date systemCreatedDate;

    //kim ekledi
    @Column(name="created_by")
    @CreatedBy
    public String createdBy;

    //kim ne zaman ekledi
    @Column(name="created_date")
    @CreatedDate
    public java.util.Date createdDate;


    //kim güncelledi
    @Column(name = "last_modified_by")
    @LastModifiedBy
    public String lastModifiedBy;

    //kim ne zaman güncelledi
    @Column(name = "last_modified_date")
    @LastModifiedDate
    public java.util.Date lastModifiedDate;



}
