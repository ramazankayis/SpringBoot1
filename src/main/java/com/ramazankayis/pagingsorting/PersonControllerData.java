package com.ramazankayis.pagingsorting;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonControllerData {

    @Autowired
    PersonRepository personRepository;

    //http://localhost:8080/person44/save
    @GetMapping("/person44/save")
    @ResponseBody
    public String getPerson44Save() {
        for (int i = 1; i <= 10; i++) {
            PersonEntity personEntity =
                    PersonEntity
                            .builder()
                            .personName("Person adı " + i)
                            .personSurName("person soyadı " + i)
                            .build();
            personRepository.save(personEntity);
        }
        return "Kaydetme başarılı";
    }

    //sorting: küçükten büyüğe doğru sıralama
    //http://localhost:8080/person/sorting/asc
    @GetMapping("person/sorting/asc")
    @ResponseBody
    public String personSortingAsc() {
        Sort sort = Sort.by("personName");
        Iterable<PersonEntity> sortingList = personRepository.findAll(sort);
        for (PersonEntity temp : sortingList) {
            log.info(temp + " ");
        }
        return sortingList + " ";
    }


    //sorting:  büyükten küçükten doğru sıralama
    //http://localhost:8080/person/sorting/desc
    @GetMapping("person/sorting/desc")
    @ResponseBody
    public String personSortingDesc() {
        Sort sort = Sort.by("personName").descending();
        Iterable<PersonEntity> sortingList = personRepository.findAll(sort);

        for (PersonEntity temp : sortingList) {
            log.info(temp + " ");
        }
        return sortingList + " ";
    }

    //paging: manuel
    //http://localhost:8080/person/paging
    @GetMapping("person/paging")
    @ResponseBody
    public String personPaging() {
        //0:page  5:data sayısı
        Pageable pageable = PageRequest.of(0, 5);
        Page<PersonEntity> pageListem = personRepository.findAll(pageable);
        for (PersonEntity temp : pageListem) {
            log.info(temp + " ");
        }
        return pageListem+"" ;
    }

    //paging: page dynamic but size manuel data
    //http://localhost:8080/person/paging/0
    @GetMapping("person/paging/{page}")
    @ResponseBody
    public String personPageAndSize(@PathVariable(name="page") int page) {
        //0:page  5:data sayısı
        Pageable pageable = PageRequest.of(page, 5);
        Page<PersonEntity> pageListem = personRepository.findAll(pageable);
        for (PersonEntity temp : pageListem) {
            log.info(temp + " ");
        }
        return pageListem+"" ;
    }

    //paging
    //http://localhost:8080/person/paging/0/10
    @GetMapping("person/paging/{page}/{size}")
    @ResponseBody
    public String personPageAndSizeData(
            @PathVariable(name="page") int page,
            @PathVariable(name="size") int size
    ) {
        //0:page  5:data sayısı
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonEntity> pageListem = personRepository.findAll(pageable);
        for (PersonEntity temp : pageListem) {
            log.info(temp + " ");
        }
        return pageListem+"" ;
    }


    //paging and sorting
}
