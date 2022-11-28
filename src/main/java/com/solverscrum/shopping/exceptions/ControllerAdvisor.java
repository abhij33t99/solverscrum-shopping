package com.solverscrum.shopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<String> customerNotFound(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShipperNotFoundException.class)
    ResponseEntity<String> shipperNotFound(ShipperNotFoundException shipperNotFoundException) {
        return new ResponseEntity<>(shipperNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    ResponseEntity<String> supplierNotFound(SupplierNotFoundException supplierNotFoundException) {
        return new ResponseEntity<>(supplierNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String> productNotFound(ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    ResponseEntity<String> orderNotFound(OrderNotFoundException orderNotFoundException) {
        return new ResponseEntity<>(orderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> methodArgumentViolated(MethodArgumentNotValidException methodArgumentNotValidException) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors())
            stringBuilder.append(fieldError.getField() + " : " + fieldError.getDefaultMessage() + "\n");
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.valueOf(406));
    }
}
