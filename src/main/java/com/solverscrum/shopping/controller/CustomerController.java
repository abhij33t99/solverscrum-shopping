package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.service.CustomerService;
import com.solverscrum.shopping.utils.ValidList;
import com.solverscrum.shopping.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@Validated
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<CustomerVo>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/customers/{id}")
    public ResponseEntity<CustomerVo> getCustomerById(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    //using valid list instead of list as spring level validation works on objects and not iterables and hence jpa level validation was working.
    // And it's a bad idea to go for jpa level validation
    @PostMapping("/api/v1/customers")
    public ResponseEntity<String> addCustomers(@RequestBody @Valid ValidList<CustomerVo> customerVos) {
        return new ResponseEntity<>(customerService.saveCustomers(customerVos), HttpStatus.OK);
    }

    @PutMapping("/api/v1/customers/{id}")
    public ResponseEntity<String> editCustomer(@PathVariable Integer id, @RequestBody CustomerVo customer) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
