package com.softech.petben.controllers;

import com.softech.petben.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    private ProductService productService;

    public ProductAdminController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/", ""})
    public String listProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "admin/product/list";
    }

}
