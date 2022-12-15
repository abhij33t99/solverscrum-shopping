package com.solverscrum.shopping.exception;

import org.hsqldb.HsqlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomerException.class)
    ResponseEntity<String> customerNotFound(CustomerException customerNotFoundException) {
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShipperException.class)
    ResponseEntity<String> shipperNotFound(ShipperException shipperNotFoundException) {
        return new ResponseEntity<>(shipperNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupplierException.class)
    ResponseEntity<String> supplierNotFound(SupplierException supplierNotFoundException) {
        return new ResponseEntity<>(supplierNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductException.class)
    ResponseEntity<String> productNotFound(ProductException productNotFoundException) {
        return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderException.class)
    ResponseEntity<String> orderNotFound(OrderException orderNotFoundException) {
        return new ResponseEntity<>(orderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> methodArgumentViolated(MethodArgumentNotValidException methodArgumentNotValidException) {
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors())
            stringBuilder.append(fieldError.getField() + " : " + fieldError.getDefaultMessage() + "\n");
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.valueOf(406));
    }

    @ExceptionHandler(HsqlException.class)
    ResponseEntity<String> hsqlException(HsqlException hsqlException){
        return new ResponseEntity<>(hsqlException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
