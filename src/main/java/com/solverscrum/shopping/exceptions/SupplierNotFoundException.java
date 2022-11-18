package com.solverscrum.shopping.exceptions;

public class SupplierNotFoundException extends Exception{

    public SupplierNotFoundException(Integer id){
        super("Supplier not found with the id : "+id+". Product not added!");
    }
}
