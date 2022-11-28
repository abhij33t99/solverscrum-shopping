package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.exceptions.ProductNotFoundException;
import com.solverscrum.shopping.exceptions.SupplierNotFoundException;
import com.solverscrum.shopping.service.ProductService;
import com.solverscrum.shopping.service.ValidList;
import com.solverscrum.shopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductVo>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseEntity<ProductVo> getProductById(@PathVariable int id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/product")
    public ResponseEntity<String> addProducts(@RequestBody @Valid ValidList<ProductVo> productVos) throws SupplierNotFoundException {
        return new ResponseEntity<>(productService.addProduct(productVos), HttpStatus.OK);
    }
}
