package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.service.SupplierService;
import org.springframework.web.bind.annotation.*;
import com.solverscrum.shopping.utils.ValidList;
import com.solverscrum.shopping.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@Validated
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/api/v1/suppliers")
    public ResponseEntity<List<SupplierVo>> getSuppliers() {
        return new ResponseEntity<>(supplierService.getSuppliers(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/suppliers")
    public ResponseEntity<String> addSuppliers(@RequestBody @Valid ValidList<SupplierVo> supplierVos) {
        return new ResponseEntity<>(supplierService.addSuppliers(supplierVos), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/suppliers/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id){
        return new ResponseEntity<>(supplierService.deleteSupplier(id),HttpStatus.OK);
    }
}
