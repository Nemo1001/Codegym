package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.ProvinceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/list")
    public ModelAndView listProvinces() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProvinceForm(@PathVariable ("id") Long id) {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province);
            modelAndView.addObject("message", "delete successfully");
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public ModelAndView deleteProvince(@ModelAttribute ("province") Province province){
        provinceService.remove(province.getId());
        ModelAndView modelAndView = new ModelAndView("/province/delete");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "delete success");
        return modelAndView;
    }

}
