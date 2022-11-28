package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.ShipperRepository;
import com.solverscrum.shopping.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    public List<ShipperVo> getShippers() {
        List<ShipperVo> shipperVos = shipperRepository.findAll()
                .stream()
                .map(ShipperService::convertToShipperVo)
                .collect(Collectors.toList());
        return shipperVos;
    }

    public ShipperVo getShipperById(Integer id) throws ShipperNotFoundException {
        Optional<Shippers> shipper = shipperRepository.findById(id);
        if (shipper.isEmpty())
            throw new ShipperNotFoundException(id);
        return convertToShipperVo(shipper.get());
    }

    public String addShippers(ValidList<ShipperVo> shipperVos) {
        List<Shippers> shippers = shipperVos.getList().stream()
                        .map(ShipperService::convertToShipper)
                                .collect(Collectors.toList());
        shipperRepository.saveAll(shippers);

        return "Added all shippers";
    }

    private static Shippers convertToShipper(ShipperVo shipperVo) {
        Shippers shipper = new Shippers();
        shipper.setShipperName(shipperVo.getShipperName());
        shipper.setPhone(shipperVo.getPhone());

        return shipper;
    }

    public static ShipperVo convertToShipperVo(Shippers shipper){
        ShipperVo shipperVo = new ShipperVo();
        shipperVo.setShipperId(shipper.getShipperId());
        shipperVo.setShipperName(shipper.getShipperName());
        shipperVo.setPhone(shipper.getPhone());

        return shipperVo;
    }
}
