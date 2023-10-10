package com.multipolar.bootcamp.kyc.controller;

import com.multipolar.bootcamp.kyc.domain.Customer;
import com.multipolar.bootcamp.kyc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createOrUpdateCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id,@RequestBody Customer customer){
        customer.setId(id);
        return customerService.createOrUpdateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }


}
