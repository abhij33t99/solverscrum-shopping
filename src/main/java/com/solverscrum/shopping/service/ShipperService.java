package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    public List<Shippers> getShippers(){
        return shipperRepository.findAll();
    }

    public Shippers getShipperById(Integer id) throws ShipperNotFoundException {
        Optional<Shippers> shipper = shipperRepository.findById(id);
        if(shipper.isEmpty())
            throw new ShipperNotFoundException(id);
        return shipper.get();
    }
}
