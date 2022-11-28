package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Products;
import com.solverscrum.shopping.entity.Suppliers;
import com.solverscrum.shopping.exceptions.ProductNotFoundException;
import com.solverscrum.shopping.exceptions.SupplierNotFoundException;
import com.solverscrum.shopping.repository.ProductRepository;
import com.solverscrum.shopping.repository.SupplierRepository;
import com.solverscrum.shopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.solverscrum.shopping.service.SupplierService.convertToSupplierVo;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public List<ProductVo> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductService::convertToProductVo)
                .collect(Collectors.toList());
    }

    public ProductVo getProductById(Integer id) throws ProductNotFoundException {
        Optional<Products> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ProductNotFoundException(id);
        return convertToProductVo(product.get());
    }

    @Transactional(rollbackOn = {SupplierNotFoundException.class})
    public String addProduct(ValidList<ProductVo> productVos) throws SupplierNotFoundException {
        for(ProductVo productVo : productVos.getList()){
            Optional<Suppliers> supplier = supplierRepository.findById(productVo.getSupplierId());
            if(supplier.isEmpty())
                throw new SupplierNotFoundException(productVo.getSupplierId());
            productRepository.save(convertToProduct(productVo));
        }
        return "Added";
    }

    private static Products convertToProduct(ProductVo productVo) {
        Products product = new Products();
        product.setProductName(productVo.getProductName());
        product.setUnit(productVo.getUnit());
        product.setPrice(productVo.getPrice());
        Suppliers supplier = new Suppliers();
        supplier.setSupplierId(productVo.getSupplierId());
        product.setSupplier(supplier);

        return product;
    }

    static ProductVo convertToProductVo(Products product){
        ProductVo productVo = new ProductVo();
        productVo.setProductId(product.getProductId());
        productVo.setProductName(product.getProductName());
        productVo.setUnit(product.getUnit());
        productVo.setPrice(product.getPrice());
        productVo.setSupplier(convertToSupplierVo(product.getSupplier()));
        return productVo;
    }

}
