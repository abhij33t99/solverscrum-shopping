package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Supplier;
import com.solverscrum.shopping.repository.SupplierRepository;
import com.solverscrum.shopping.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solverscrum.shopping.utils.ValidList;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierVo> getSuppliers() {
        return supplierRepository.findAll().stream()
                .map(SupplierService::convertToSupplierVo)
                .collect(Collectors.toList());
    }

    public String addSuppliers(ValidList<SupplierVo> supplierVos) {
        List<Supplier> suppliers = supplierVos.getList().stream()
                .map(SupplierService::convertToSupplier)
                .collect(Collectors.toList());
        supplierRepository.saveAll(suppliers);
        return "Added all suppliers.";
    }

    public String deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
        return "Deleted supplier with id : "+id;
    }

    private static Supplier convertToSupplier(SupplierVo supplierVo) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierVo.getSupplierName());
        supplier.setAddress(supplierVo.getAddress());
        supplier.setCity(supplierVo.getCity());
        supplier.setPostalCode(supplierVo.getPostalCode());
        supplier.setPhone(supplierVo.getPhone());

        return supplier;
    }

    public static SupplierVo convertToSupplierVo(Supplier supplier){
        SupplierVo supplierVo = new SupplierVo();
        supplierVo.setSupplierId(supplier.getSupplierId());
        supplierVo.setSupplierName(supplier.getSupplierName());
        supplierVo.setAddress(supplier.getAddress());
        supplierVo.setCity(supplier.getCity());
        supplierVo.setPostalCode(supplier.getPostalCode());
        supplierVo.setPhone(supplier.getPhone());
        return supplierVo;
    }
}
