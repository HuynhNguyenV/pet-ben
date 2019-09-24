package com.softech.petben.services.springdatajpa;

import com.softech.petben.domain.Customer;
import com.softech.petben.repositories.CustomerRepository;
import com.softech.petben.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerSDJpaService implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerSDJpaService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.findByLastName(name);
    }

    @Override
    public Customer findById(Integer integer) {
        return customerRepository.findById(integer).orElse(null);
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        customerRepository.deleteById(integer);
    }
}
