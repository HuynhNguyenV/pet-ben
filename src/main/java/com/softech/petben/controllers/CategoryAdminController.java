package com.softech.petben.controllers;

import com.softech.petben.domain.Category;
import com.softech.petben.repositories.CategoryRepository;
import com.softech.petben.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/category")
public class CategoryAdminController {

    private final CategoryService categoryService;

    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
    public String listCategories(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("categories", categoryRepository.findAll(new PageRequest(page, 4)));
        model.addAttribute("currentPage", page);
        return "admin/category/list";
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("categories", categoryService.search(name));
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
