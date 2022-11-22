package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Suppliers;
import com.solverscrum.shopping.repository.SupplierRepository;
import com.solverscrum.shopping.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Suppliers> getSuppliers(){
        return supplierRepository.findAll();
    }

    public String addSuppliers(List<SupplierVo> supplierVos){
        List<Suppliers> suppliers = new ArrayList<>();
        for(SupplierVo supplierVo : supplierVos)
            suppliers.add(convertToSupplier(supplierVo));
        supplierRepository.saveAll(suppliers);
        return "Added all suppliers.";
    }

    public static Suppliers convertToSupplier(SupplierVo supplierVo){
        Suppliers supplier = new Suppliers();
        supplier.setSupplierName(supplierVo.getSupplierName());
        supplier.setAddress(supplierVo.getAddress());
        supplier.setCity(supplierVo.getCity());
        supplier.setPostalCode(supplierVo.getPostalCode());
        supplier.setPhone(supplierVo.getPhone());

        return supplier;
    }
}
