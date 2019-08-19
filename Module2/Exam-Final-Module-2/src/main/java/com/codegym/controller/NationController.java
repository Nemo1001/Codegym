package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.CityService;
import com.codegym.service.NationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private NationService nationService;
    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public ModelAndView listProvinces() {
        Iterable<Nation> nations = nationService.findAll();
        ModelAndView modelAndView = new ModelAndView("/nation/list");
        modelAndView.addObject("nations", nations);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProvince(@ModelAttribute("nation") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/create");
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message", "created successfully");
        return "redirect:/nation/list/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Nation nation = nationService.findById(id);
        if (nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/edit");
            modelAndView.addObject("nation", nation);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateProvince(@ModelAttribute("province") Nation nation) {
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("/nation/edit");
        modelAndView.addObject("nation", nation);
        modelAndView.addObject("message", "Nation updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteNationForm(@PathVariable("id") Long id) {
        Nation nation = nationService.findById(id);
        if (nation != null) {
            ModelAndView modelAndView = new ModelAndView("/nation/delete");
            modelAndView.addObject("nation", nation);
            modelAndView.addObject("message", "delete successfully");
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public String deleteProvince(@ModelAttribute("nation") Nation nation) {
        nationService.remove(nation.getId());
        ModelAndView modelAndView = new ModelAndView("/nation/delete");
        modelAndView.addObject("nation", nation);
        modelAndView.addObject("message", "delete success");
        return "redirect:/nation/list/";
    }

    }




