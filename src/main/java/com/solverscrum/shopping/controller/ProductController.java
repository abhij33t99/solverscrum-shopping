package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.entity.Products;
import com.solverscrum.shopping.exceptions.ProductNotFoundException;
import com.solverscrum.shopping.exceptions.SupplierNotFoundException;
import com.solverscrum.shopping.service.ProductService;
import com.solverscrum.shopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<Products>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/product")
    public ResponseEntity<String> addProduct(@RequestBody @Valid  ProductVo productVo) throws SupplierNotFoundException, MethodArgumentNotValidException {
        return new ResponseEntity<>(productService.addProduct(productVo), HttpStatus.OK);
    }
}
