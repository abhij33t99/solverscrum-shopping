package com.solverscrum.shopping.controller;

import com.solverscrum.shopping.exception.ShipperException;
import com.solverscrum.shopping.service.ShipperService;
import com.solverscrum.shopping.utils.ValidList;
import com.solverscrum.shopping.vo.ShipperVo;
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
public class ShipperController {
    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shippers")
    public ResponseEntity<List<ShipperVo>> getShippers() {
        return new ResponseEntity<>(shipperService.getShippers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/shipper/{id}")
    public ResponseEntity<ShipperVo> getShippersById(@PathVariable Integer id) throws ShipperException {
        return new ResponseEntity<>(shipperService.getShipperById(id), HttpStatus.OK);
    }

    @PostMapping("/api/v1/shippers")
    public ResponseEntity<String> addShippers(@RequestBody @Valid ValidList<ShipperVo> shipperVos) {
        return new ResponseEntity<>(shipperService.addShippers(shipperVos), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/shippers/{id}")
    public ResponseEntity<String> deleteShippers(@PathVariable Integer id){
        return new ResponseEntity<>(shipperService.deleteShipper(id),HttpStatus.OK);
    }
}
