package com.ramazankayis.pagingsorting;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonControllerData {

    @Autowired
    PersonRepository personRepository;

    //http://localhost:8080/person44/save
    @GetMapping("/person44/save")
    @ResponseBody
    public String getPerson44Save(){
        for(int i=1; i<=10; i++){
            PersonEntity personEntity=
                    PersonEntity
                            .builder()
                            .personName("Person adı "+i)
                            .personSurName("person soyadı "+i)
                            .build();
            personRepository.save(personEntity);
        }
        return  "Kaydetme başarılı";
    }

    //paging
    //http://localhost:8080/person/sorting
    @GetMapping("person/sorting")
    @ResponseBody
    public  String personSorting(){
        Sort sort=Sort.by("personName");
        Iterable<PersonEntity> sortingList=  personRepository.findAll(sort);

        for(PersonEntity temp :sortingList){
            log.info(temp+" ");
        }
        return sortingList+" ";
    }


    //sorting

    //paging and sorting
}
