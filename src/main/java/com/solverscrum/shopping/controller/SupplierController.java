package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.entity.Suppliers;
import com.solverscrum.shopping.service.SupplierService;
import com.solverscrum.shopping.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/api/v1/suppliers")
    public ResponseEntity<List<Suppliers>> getSuppliers(){
        return new ResponseEntity<>(supplierService.getSuppliers(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/suppliers")
    public ResponseEntity<String> addSuppliers(@RequestBody List<SupplierVo> supplierVos){
        return new ResponseEntity<>(supplierService.addSuppliers(supplierVos), HttpStatus.OK);
    }
}
