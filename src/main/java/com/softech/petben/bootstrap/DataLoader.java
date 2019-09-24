package com.softech.petben.bootstrap;

import com.softech.petben.domain.Category;
import com.softech.petben.domain.Product;
import com.softech.petben.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;
    private final RoleService roleService;
    private final ProductService productService;
    private final CustomerService customerService;
    private final UserService userService;

    public DataLoader(CategoryService categoryService, RoleService roleService, ProductService productService, CustomerService customerService, UserService userService) {
        this.categoryService = categoryService;
        this.roleService = roleService;
        this.productService = productService;
        this.customerService = customerService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProduct();
    }

    private void loadProduct() {
        Category category = new Category();
        category.setName("food");
        categoryService.save(category);

        Category category2 = new Category();
        category2.setName("milk");
        categoryService.save(category2);

        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Description Product 1");
        product.setPrice(12.33);
        product.setImage("images/product-1.jpeg");
        product.setCategory(category);
        productService.save(product);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Description Product 2");
        product2.setPrice(33.33);
        product2.setCategory(category2);
        product2.setImage("images/product-2.jpeg");
        productService.save(product2);

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Description Product 3");
        product3.setPrice(33.33);
        product3.setCategory(category2);
        product3.setImage("images/product-3.jpeg");
        productService.save(product3);

        Product product4 = new Product();
        product4.setName("Product 4");
        product4.setDescription("Description Product 4");
        product4.setPrice(33.33);
        product4.setCategory(category2);
        product4.setImage("images/product-4.jpeg");
        productService.save(product4);

    }
}
