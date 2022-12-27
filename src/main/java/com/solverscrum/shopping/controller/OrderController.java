package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.exception.CustomerException;
import com.solverscrum.shopping.exception.OrderException;
import com.solverscrum.shopping.exception.ProductException;
import com.solverscrum.shopping.exception.ShipperException;
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
@CrossOrigin@RestController
@Validated
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/api/v1/orders")
    public ResponseEntity<List<OrderVo>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/orders/{id}")
    public ResponseEntity<OrderVo> getOrderById(@PathVariable Integer id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/orders")
    public ResponseEntity<String> addOrder(@RequestBody @Valid OrderVo order)throws ParseException{
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.OK);
    }

    @GetMapping("/api/v1/orders/cus/{id}")
    public ResponseEntity<List<OrderVo>> getOrderByCustomerId(@PathVariable Integer id){
        return new ResponseEntity<>(orderService.getOrderByCustomerId(id),HttpStatus.OK);
    }
}
