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

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public List<Products> getProducts(){
        return productRepository.findAll();
    }

    public Products getProductById(Integer id) throws ProductNotFoundException{
        Optional<Products> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new ProductNotFoundException(id);
        return product.get();
    }

    public String addProduct(ProductVo productVo) throws SupplierNotFoundException {
        Products product = convertToProduct(productVo);
        Integer supplierId = product.getSupplier().getSupplierId();
        Optional<Suppliers> supplier = supplierRepository.findById(supplierId);
        if(supplier.isEmpty())
            throw new SupplierNotFoundException(supplierId);
        productRepository.save(product);
        return "Added!!";
    }

    public static Products convertToProduct(ProductVo productVo){
        Products product = new Products();
        product.setProductName(productVo.getProductName());
        product.setUnit(productVo.getUnit());
        product.setPrice(productVo.getPrice());
        Suppliers supplier = new Suppliers();
        supplier.setSupplierId(productVo.getSupplierId());
        product.setSupplier(supplier);

        return product;
    }


}
