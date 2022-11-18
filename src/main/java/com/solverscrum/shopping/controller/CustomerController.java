package com.solverscrum.shopping.controller;

//import static dummydata.DummyData.customers;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<Customers>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/customers/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/customers")
    public ResponseEntity<String> addCustomers(@RequestBody List<Customers> customers){
        return new ResponseEntity<>(customerService.addCustomers(customers), HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    public ResponseEntity<String> editCustomer(@RequestBody Customers customer) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.modifyCustomer(customer), HttpStatus.OK);
    }

}
