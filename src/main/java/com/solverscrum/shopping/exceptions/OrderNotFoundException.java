package com.solverscrum.shopping.exceptions;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(Integer id) {
        super("Order not found with the id : " + id);
    }
}
