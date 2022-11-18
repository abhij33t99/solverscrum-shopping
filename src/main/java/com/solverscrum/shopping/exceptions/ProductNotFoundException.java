package com.solverscrum.shopping.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Integer id){
        super("Product not found with id : "+id);
    }
}
