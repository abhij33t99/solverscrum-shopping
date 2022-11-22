package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.service.ShipperService;
import com.solverscrum.shopping.service.ValidList;
import com.solverscrum.shopping.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ShipperController {
    @Autowired
    ShipperService shipperService;
    @GetMapping("/api/v1/shippers")
    public ResponseEntity<List<Shippers>> getShippers(){
        return new ResponseEntity<>(shipperService.getShippers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/shipper/{id}")
    public ResponseEntity<Shippers> getShippersById(@PathVariable Integer id) throws ShipperNotFoundException {
        return new ResponseEntity<>(shipperService.getShipperById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/shippers")
    public ResponseEntity<String> addShippers(@RequestBody @Valid ValidList<ShipperVo> shipperVos) throws ConstraintViolationException {
        return new ResponseEntity<>(shipperService.addShippers(shipperVos), HttpStatus.OK);
    }
}
