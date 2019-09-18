package com.softech.petben.bootstrap;

import com.softech.petben.domain.Category;
import com.softech.petben.domain.Customer;
import com.softech.petben.domain.Product;
import com.softech.petben.domain.Role;
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
        loadData();
        loadProduct();
        loadCustomer();
    }

    private void loadData(){
//        Category category = new Category();
//        category.setName("food");
//        categoryService.save(category);

        // Role
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);

//        User user = new User();
//        user.setUsername("Admin");
//        user.setActive(true);
//        user.setPassword("123456");
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleAdmin);
//        user.setRoles(roles);
//        userService.save(user);
    }

    private void loadCustomer(){
        Customer customer = new Customer();
        customer.setLastName("Tom");
        customer.setFirstName("My");
        customer.setAddress("132 Duy Tan");
        customer.setPhoneNumber("1234567");
        customer.setEmail("abc@gmail.com");
        customerService.save(customer);

        Customer customer2 = new Customer();
        customer2.setLastName("Viet");
        customer2.setFirstName("Huynh");
        customer2.setAddress("99 Luong Tan");
        customer2.setPhoneNumber("3232323");
        customer2.setEmail("doi@gmail.com");
        customerService.save(customer2);
    }

    private void loadProduct(){
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
