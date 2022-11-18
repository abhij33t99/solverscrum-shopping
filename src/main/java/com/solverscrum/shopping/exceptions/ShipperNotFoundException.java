package com.solverscrum.shopping.exceptions;

public class ShipperNotFoundException extends Exception{
    public ShipperNotFoundException(Integer id){
        super("Shipper not found with the id : "+id);
    }
}
