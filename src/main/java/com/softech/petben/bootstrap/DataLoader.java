package com.softech.petben.bootstrap;

import com.softech.petben.domain.Category;
import com.softech.petben.domain.Role;
import com.softech.petben.services.CategoryService;
import com.softech.petben.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;
    private final RoleService roleService;

    public DataLoader(CategoryService categoryService, RoleService roleService) {
        this.categoryService = categoryService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        Category category = new Category();
        category.setName("food");
        categoryService.save(category);

        // Role
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);
    }
}
