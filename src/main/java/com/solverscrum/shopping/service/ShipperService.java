package com.solverscrum.shopping.service;
import com.solverscrum.shopping.entity.Shipper;
import com.solverscrum.shopping.exception.ShipperException;
import com.solverscrum.shopping.repository.ShipperRepository;
import com.solverscrum.shopping.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solverscrum.shopping.utils.ValidList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;

    public List<ShipperVo> getShippers() {
//        stream java 8
        List<ShipperVo> shipperVos = shipperRepository.findAll()
                .stream()
                .map(ShipperService::convertToShipperVo)
                .collect(Collectors.toList());
        return shipperVos;
    }

    public ShipperVo getShipperById(Integer id){
//        optional java8
        Optional<Shipper> shipper = shipperRepository.findById(id);
        if (shipper.isEmpty())
            throw new ShipperException("Shipper not found with id :"+id);
        return convertToShipperVo(shipper.get());
    }

    public String addShippers(ValidList<ShipperVo> shipperVos) {
        List<Shipper> shippers = shipperVos.getList().stream()
                        .map(ShipperService::convertToShipper)
                                .collect(Collectors.toList());
        shipperRepository.saveAll(shippers);

        return "Added shippers successfully";
    }

    public String deleteShipper(Integer id){
        shipperRepository.deleteById(id);
        return "Deleted shipper with id : "+id;
    }

    private static Shipper convertToShipper(ShipperVo shipperVo) {
        Shipper shipper = new Shipper();
        shipper.setShipperName(shipperVo.getShipperName());
        shipper.setPhone(shipperVo.getPhone());

        return shipper;
    }

    public static ShipperVo convertToShipperVo(Shipper shipper){
        ShipperVo shipperVo = new ShipperVo();
        shipperVo.setShipperId(shipper.getShipperId());
        shipperVo.setShipperName(shipper.getShipperName());
        shipperVo.setPhone(shipper.getPhone());

        return shipperVo;
    }
}
