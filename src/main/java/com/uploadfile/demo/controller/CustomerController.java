package com.uploadfile.demo.controller;

import com.uploadfile.demo.model.Customer;
import com.uploadfile.demo.model.CustomerForm;
import com.uploadfile.demo.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private IServiceCustomer serviceCustomer;

    @Autowired
    private Environment environment;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("list", serviceCustomer.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    private ModelAndView createForm() {
        ModelAndView create = new ModelAndView("create", "customer", new CustomerForm());
        return create;
    }

    @PostMapping("/create")
    private ModelAndView createNewCustomer(@ModelAttribute CustomerForm customerForm) throws IOException {
        ModelAndView modelAndView = new ModelAndView("create");
        MultipartFile file = customerForm.getAvatar();
        String avatar = file.getOriginalFilename();

        String folder = environment.getProperty("file_upload").toString();
        FileCopyUtils.copy(file.getBytes(), new File(folder + avatar));

        Customer customer = new Customer(customerForm.getId(), customerForm.getName(), customerForm.getEmail(), customerForm.getAddress(), avatar);
        serviceCustomer.save(customer);
        modelAndView.addObject("customer", new CustomerForm());
        modelAndView.addObject("mess", "Thanh Cong");
        return modelAndView;


    }
}
