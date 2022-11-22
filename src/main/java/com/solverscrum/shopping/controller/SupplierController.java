package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.entity.Suppliers;
import com.solverscrum.shopping.service.SupplierService;
import com.solverscrum.shopping.service.ValidList;
import com.solverscrum.shopping.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/api/v1/suppliers")
    public ResponseEntity<List<Suppliers>> getSuppliers(){
        return new ResponseEntity<>(supplierService.getSuppliers(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/suppliers")
    public ResponseEntity<String> addSuppliers(@RequestBody @Valid ValidList<SupplierVo> supplierVos) throws MethodArgumentNotValidException {
        return new ResponseEntity<>(supplierService.addSuppliers(supplierVos), HttpStatus.OK);
    }
}
