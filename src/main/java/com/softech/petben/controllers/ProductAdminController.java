package com.softech.petben.controllers;

import com.softech.petben.domain.Product;
import com.softech.petben.repositories.ProductRepository;
import com.softech.petben.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    private ProductService productService;

    public ProductAdminController(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    private ProductRepository productRepository;


    @RequestMapping(value = {"/list", "/", ""}, method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "admin/product/list";
    }

    @PostMapping("/save")
    public String save(Product product) {
        productRepository.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Product findOne(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

}
