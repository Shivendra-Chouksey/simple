package com.example.firstSpringBoot.service;

import com.example.firstSpringBoot.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class CustomerService {
    private int custIdCount = 1;
    private List<Customer> custList = new CopyOnWriteArrayList<>();
    public Customer addCustomer(Customer customer){
        customer.setCustid(custIdCount);
        custList.add(customer);
        custIdCount++;
        return customer;
    }
    public List<Customer> getCustomer(){
        return custList;
    }
    public Customer getCustomer(int custid){
        return custList.stream()
                .filter(c -> c.getCustid() == custid)
                .findFirst()
                .get();
    }
    public Customer updateCustomer(int custid,Customer customer){
        custList.stream()
                .forEach(c -> {
                    if(c.getCustid() == custid){
                        c.setCustFname(customer.getCustFname());
                        c.setCustLname(customer.getCustLname());
                        c.setCustEmail(customer.getCustEmail());
                    }
                });
        return custList.stream()
                .filter(c -> c.getCustid() == custid)
                .findFirst()
                .get();
    }
    public void deleteCustomer(int custid){
        custList.stream()
                .forEach(c -> {
                    if(c.getCustid() == custid){
                       custList.remove(c);
                    }
                });
    }
}
