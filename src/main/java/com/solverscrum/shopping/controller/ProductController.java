package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.exception.ProductException;
import com.solverscrum.shopping.exception.SupplierException;
import com.solverscrum.shopping.service.ProductService;
import com.solverscrum.shopping.utils.ValidList;
import com.solverscrum.shopping.vo.ProductVo;
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
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductVo>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVo> getProductById(@PathVariable Integer id) throws ProductException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addProducts(@RequestBody @Valid ValidList<ProductVo> productVos) throws SupplierException {
        return new ResponseEntity<>(productService.addProduct(productVos), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editProduct(@PathVariable Integer id, @RequestBody ProductVo productVo){
        return new ResponseEntity<>(productService.editProduct(id,productVo), HttpStatus.OK);
    }

}
