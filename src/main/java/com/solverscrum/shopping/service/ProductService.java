package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Products;
import com.solverscrum.shopping.entity.Supplier;
import com.solverscrum.shopping.exception.ProductException;
import com.solverscrum.shopping.exception.SupplierException;
import com.solverscrum.shopping.repository.ProductRepository;
import com.solverscrum.shopping.repository.SupplierRepository;
import com.solverscrum.shopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solverscrum.shopping.utils.ValidList;

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

    public ProductVo getProductById(Integer id){
        Optional<Products> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ProductException("Product not found with id :"+id);
        return convertToProductVo(product.get());
    }

    @Transactional(rollbackOn = SupplierException.class)
    public String addProduct(ValidList<ProductVo> productVos){
        for(ProductVo productVo : productVos.getList()){
            Optional<Supplier> supplier = supplierRepository.findById(productVo.getSupplierId());
            if(supplier.isEmpty())
                throw new SupplierException("Supplier not found with id :"+productVo.getSupplierId());
            productRepository.save(convertToProduct(productVo));
        }
        return "Added";
    }

    public String deleteProduct(Integer id){
        productRepository.deleteById(id);
        return "Deleted product with id : "+id;
    }

    public String editProduct(Integer id, ProductVo productVo){
        Products products = productRepository.findById(id).get();
        products.setProductName(productVo.getProductName());
        products.setUnit(productVo.getUnit());
        products.setPrice(productVo.getPrice());
        productRepository.save(products);
        return "Edited the product with id : "+id;
    }

    static Products convertToProduct(ProductVo productVo) {
        Products product = new Products();
        product.setProductName(productVo.getProductName());
        product.setUnit(productVo.getUnit());
        product.setPrice(productVo.getPrice());
        Supplier supplier = new Supplier();
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
