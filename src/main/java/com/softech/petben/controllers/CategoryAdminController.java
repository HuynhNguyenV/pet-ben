package com.softech.petben.controllers;

import com.softech.petben.domain.Category;
import com.softech.petben.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin/category")
public class CategoryAdminController {

//    private CategoryService categoryService;
//
//    public CategoryAdminController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping({"/list", ""})
    public String listCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/category/list";
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/delete")
    public String deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return "redirect:/admin/category";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Category findOne(Integer id) {
        return categoryRepository.findById(id).orElse(new Category());
    }
}
