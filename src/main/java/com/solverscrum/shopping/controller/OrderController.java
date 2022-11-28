package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.exceptions.OrderNotFoundException;
import com.solverscrum.shopping.exceptions.ProductNotFoundException;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.service.OrderService;
import com.solverscrum.shopping.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@Validated
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/api/v1/orders")
    public ResponseEntity<List<OrderVo>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/orders/{id}")
    public ResponseEntity<OrderVo> getOrderById(@PathVariable Integer id) throws OrderNotFoundException {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order")
    public ResponseEntity<String> addOrder(@RequestBody @Valid OrderVo order) throws CustomerNotFoundException, ShipperNotFoundException, ParseException, ProductNotFoundException {
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.OK);
    }
}
