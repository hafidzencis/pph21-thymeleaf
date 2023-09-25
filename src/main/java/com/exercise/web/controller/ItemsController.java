package com.exercise.web.controller;

import com.exercise.web.exception.UserNotFoundException;
import com.exercise.web.model.Items;
import com.exercise.web.model.ItemsDTO;
import com.exercise.web.service.ItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/")
    public String index(Model model){
        List<Items> listAll = itemsService.getAllItems();
        model.addAttribute("listAll",listAll);
        log.info("Index has been run");
        return "index";
    }

    @GetMapping("/create")
    public String createEmployeePPh21(Model model){
        ItemsDTO itemDTO = new ItemsDTO();
        model.addAttribute("itemDTO",itemDTO);
        log.info("Create view has been run");
        return "create";
    }


    @PostMapping("/create/store")
    public String storeItem(@ModelAttribute ItemsDTO itemDTO){
        log.info("store has been run");
        itemsService.createItem(itemDTO);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id,Model model, RedirectAttributes re){
        ItemsDTO itemDTO = new ItemsDTO();
        model.addAttribute("itemDTO",itemDTO);
        Items item =  itemsService.getItem(id);
        log.info(item.getName());
        model.addAttribute("item",item);
        return "update";
    }

    @PostMapping("/update/store")
    public  String updateStore(@ModelAttribute ItemsDTO itemsDTO){
        log.info("Update to: " + itemsDTO.getId());
        log.info("Update to : " + itemsDTO.getName());
        log.info("Update to : " + itemsDTO.getPasangan());
        log.info("Update to : " + itemsDTO.getJenisKelamin());
        log.info("Update to : " + itemsDTO.getStatusMenikah());
        log.info("Update to : " + itemsDTO.getBruto());
        log.info("Update to : " + itemsDTO.getTanggungan());
        itemsService.update(itemsDTO);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes re){
        log.info("Running Delete");
        itemsService.delete(id);
        log.info("Success delete");
        return "redirect:/";
    }



}
