package com.softech.petben.controllers;

import com.softech.petben.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class IndexAdminController {

    private ProductService productService;

    public IndexAdminController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/index";
    }
}
