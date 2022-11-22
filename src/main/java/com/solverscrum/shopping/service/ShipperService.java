package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.ShipperRepository;
import com.solverscrum.shopping.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public String addShippers(List<ShipperVo> shipperVos){
        List<Shippers> shippers = new ArrayList<>();
        for(ShipperVo shipperVo : shipperVos)
            shippers.add(convertToShipper(shipperVo));
        shippers.addAll(shippers);

        return "Added all shippers";
    }

    public static Shippers convertToShipper(ShipperVo shipperVo){
        Shippers shipper = new Shippers();
        shipper.setShipperName(shipperVo.getShipperName());
        shipper.setPhone(shipperVo.getPhone());

        return shipper;
    }
}
