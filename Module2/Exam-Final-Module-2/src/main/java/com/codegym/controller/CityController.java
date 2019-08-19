package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Nation;
import com.codegym.service.CityService;
import com.codegym.service.NationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nations")
    public Iterable<Nation> nations() {
        return nationService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listCity(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<City> citys;
        if (s.isPresent()) {
            citys = cityService.findAllByNameContaining(s.get(), pageable);
        } else {
            citys = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("citys", citys);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "new city created");
        return "redirect:/city/list/";
    }

     @GetMapping("/edit/{id}")
    public ModelAndView showEditCityForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "updated successfully ");
        modelAndView.addObject("message", "deleted successfully ");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
            modelAndView.addObject("message", "deleted successfully ");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public String removeCustomer(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        modelAndView.addObject("message", "deleted successfully ");
        return "redirect:/city/list/";
    }


    @GetMapping("/view/{id}")
    public ModelAndView viewNation(@PathVariable("id") Long id) {
        Nation nation = nationService.findById(id);
        if (nation == null) {
            return new ModelAndView("/error-404");
        } else {
            Iterable<City> cities = cityService.findAllByNation(nation);
            ModelAndView modelAndView = new ModelAndView("/city/view");
            modelAndView.addObject("Nation", nation);
            modelAndView.addObject("cities", cities);
            return modelAndView;

        }
    }
}