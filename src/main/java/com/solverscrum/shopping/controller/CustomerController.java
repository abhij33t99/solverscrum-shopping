package com.solverscrum.shopping.controller;

//import static dummydata.DummyData.customers;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.service.CustomerService;
import com.solverscrum.shopping.service.ValidList;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
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

    //using valid list instead of list as spring level validation works on objects and not iterables and hence jpa level validation was working.
    // And it's a bad idea to go for jpa level validation
    @PostMapping("/api/v1/customers")
    public ResponseEntity<String> addCustomers(@RequestBody @Valid ValidList<CustomerVo> customers)throws MethodArgumentNotValidException {
        return new ResponseEntity<>(customerService.addCustomers(customers), HttpStatus.OK);
    }

    @PutMapping("/api/v1/customer")
    public ResponseEntity<String> editCustomer(@RequestBody Customers customer) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.modifyCustomer(customer), HttpStatus.OK);
    }

}
