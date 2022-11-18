package com.solverscrum.shopping.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(Integer id){
        super("Customer not found with id : "+id);
    }
}
