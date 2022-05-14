package com.ramazankayis.form;

import com.ramazankayis.entity.repository.IComputer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@Log4j2
public class ComputerData {

    @Autowired
    IComputer iComputer;

    //CRUD
    //Save
    //normal save sql: INSERT INTO computer (`computer_mac_id`, `computer_name`, `computer_price`, `created_date`) VALUES ('mac-id: 06d818a9-5798-4b2b-a00a-07c2bac55c794', 'computerAdi', '1600', '2022-04-30 09:37:02');
    // http://localhost:8080/computer/manuel/save
    @GetMapping("/computer/manuel/save")
    @ResponseBody
    public String saveComputer(){
        UUID uuid=UUID.randomUUID();
        for(int i=1; i<=10; i++){
            ComputerEntity computer=ComputerEntity
                    .builder()
                    .computerId(0L)
                    .computerName("computerAdi")
                    .computerMacId("mac-id: "+uuid)
                    .computerPrice(1500)
                    .build();
            iComputer.save(computer);
            log.info(computer);
        }
        return "computer Kaydedildi";
    }



    // Get
    // http://localhost:8080/computer/save
    @GetMapping("/computer/save")
    public String getForm(Model model) {
        Iterable<ComputerEntity> computerEntities =  iComputer.findAll();
        model.addAttribute("form_list",computerEntities);
        model.addAttribute("form_computer", new ComputerEntity());
        return "Spring_Mvc_Data_Form";
    }

    // Post
    // http://localhost:8080/computer/save
    @PostMapping("/computer/save")
    public String postForm(@Valid @ModelAttribute("form_computer") ComputerEntity computerEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "Spring_Mvc_Data_Form";
        }

        UUID uuid=UUID.randomUUID();
        computerEntity.setComputerMacId(uuid.toString());

        iComputer.save(computerEntity);
        log.info(computerEntity);
        return "success";
    }


    //find ==> Filtreleme
    // http://localhost:8080/computer/filter/4
    //normal find sql: select * from computer where id=5;
    @GetMapping("/computer/filter/{id}")
    @ResponseBody
    public String findByIdComputer(@PathVariable(name="id") Long id){
        Optional<ComputerEntity> optionalEntity= iComputer.findById(id);
        if(optionalEntity.isPresent()){
            ComputerEntity computer= optionalEntity.get();
            log.info("Bulma Başarılı:");
            return computer+"Data";
        }else{
            return id+" ID: data yoktur";
        }
    }

    //find computername
    // http://localhost:8080/computer/10
    @GetMapping("/computer/{id}")
    @ResponseBody
    public String findByIdComputerId(@PathVariable(name="id") Long id,Model model){
        Optional<ComputerEntity> optionalEntity= iComputer.findById(id);
        if(optionalEntity.isPresent()){
            ComputerEntity computer= optionalEntity.get();
            model.addAttribute("show_key",computer);
            log.info(computer);
            return computer+"";
            // return "redirect:/";
        }else{
            log.error(id+" id yoktur");
            return id+" ID: data yoktur";
        }
    }



    //find computername
    // http://localhost:8080/computer/computername/computerAdi1
    @GetMapping("/computer/computername/{name}")
    @ResponseBody
    public String findByIdComputerSpecialName(@PathVariable(name="name") String name){
        List<ComputerEntity> listem= iComputer.findComputerEntitiesByComputerName(name);
        for(ComputerEntity temp :listem){
            log.info(temp);
        }
        return "listem: "+listem;
    }


    //Delete ==> Silmek
    // http://localhost:8080/computer/delete/3
    //normal delete sql:delete from computer WheRE (`id` = '3');
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String deleteByIdComputer(@PathVariable(name="id") Long id,Model model){
        Optional<ComputerEntity> optionalEntity= iComputer.findById(id);
        if(optionalEntity.isPresent()){
            ComputerEntity computer= optionalEntity.get();
            iComputer.deleteById(id);
            model.addAttribute("delete_key",id+" id silinmiştir");
            return id+"id Silinmiştir";
            // return "redirect:/";
        }else{
            return id+" ID: data yoktur";
        }
    }

    //Update ==> Güncellemek
    // http://localhost:8080/computer/update/8
    //normal update sql: update computer SET `computer_name` = 'computerAdi1' WHERE (`id` = '1');
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String updateByIdComputer(@PathVariable(name="id") Long id){
        Optional<ComputerEntity> optionalEntity= iComputer.findById(id);
        String computerName,computerMacId;
        double computerPrice;

        if(optionalEntity.isPresent()){
            ComputerEntity computer= optionalEntity.get();
            computerName= JOptionPane.showInputDialog("Bilgisayar computerName giriniz");
            computerPrice=Double.valueOf(JOptionPane.showInputDialog("Bilgisayar computerPrice giriniz"));
            computerMacId= JOptionPane.showInputDialog("Bilgisayar computerMacId giriniz");


            computer.setComputerMacId(computerMacId);
            computer.setComputerName(computerName);
            computer.setComputerPrice(computerPrice);
            iComputer.save(computer);
            return "Güncelleme Başarılı";
        }else{
            return "ID:"+id+" data yoktur";
        }
    }


}
