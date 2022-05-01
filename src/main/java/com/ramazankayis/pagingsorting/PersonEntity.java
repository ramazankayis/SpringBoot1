package com.ramazankayis.pagingsorting;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_data")
public class PersonEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID=1L;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_surname")
    private String personSurName;

}
