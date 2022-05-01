package com.ramazankayis.pagingsorting;
import org.hibernate.annotations.CreationTimestamp;


import com.ramazankayis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "person_data")
public class PersonEntity extends BaseEntity implements Serializable {
    public static final long serialVersionUID=1L;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_surname")
    private String personSurName;

}
