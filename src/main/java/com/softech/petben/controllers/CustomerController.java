package com.softech.petben.controllers;

import com.softech.petben.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "admin/customer/list";
    }

}
