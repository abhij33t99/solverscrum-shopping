package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipperController {
    @Autowired
    ShipperService shipperService;
    @GetMapping("/api/v1/shipper")
    public ResponseEntity<List<Shippers>> getShippers(){
        return new ResponseEntity<>(shipperService.getShippers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/shipper/{id}")
    public ResponseEntity<Shippers> getShippersById(@PathVariable Integer id) throws ShipperNotFoundException {
        return new ResponseEntity<>(shipperService.getShipperById(id), HttpStatus.OK);
    }
}
