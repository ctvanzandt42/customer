package com.example.customer.controller;


import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class MainController {
    @Autowired
    CustomerService customerService;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public String customer(Model model) {
        List<Customer> customers = customerService.get();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping(path = "/add-customer", method = RequestMethod.GET)
    public String addCustomer() {
        return "add-customer";
    }


    @RequestMapping(path = "/view-customer/{id}", method = RequestMethod.GET)
    public String viewCustomer( @PathVariable("id") int id, Model model){
        Customer customer = customerService.getById(id);
        model.addAttribute("customer", customer);
        return "view-customer";
    }
    @RequestMapping(path ="/add-customer", method = RequestMethod.POST)
    public String newCustomerProperties(@ModelAttribute("newCustomer") Customer newCustomer){
        System.out.println(newCustomer);
        customerService.add(newCustomer);
        return "redirect:customers";
    }
}