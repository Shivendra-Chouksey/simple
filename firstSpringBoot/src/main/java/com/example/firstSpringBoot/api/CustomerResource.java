package com.example.firstSpringBoot.api;

import com.example.firstSpringBoot.model.Customer;
import com.example.firstSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @GetMapping("/{custid}")
    public Customer getCustomer(@PathVariable("custId") int custid) {
        return customerService.getCustomer(custid);
    }

    @PutMapping("/{custid}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{custid}")
    public void deleteCustomer(@PathVariable("custid") int custid) {
        customerService.deleteCustomer(custid);
    }
}
