package com.codegym.controller;

import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import com.codegym.model.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

  /*  @GetMapping("/")
    public ModelAndView findAll(){
        List<Customer> customerList = CustomerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/");
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }*/

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "view";
    }
    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

}

