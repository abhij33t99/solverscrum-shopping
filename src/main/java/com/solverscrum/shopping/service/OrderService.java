package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.entity.Orders;
import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.exceptions.OrderNotFoundException;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.repository.OrderRepository;
import com.solverscrum.shopping.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShipperRepository shipperRepository;

    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

    public Orders getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Orders> order = orderRepository.findById(id);
        if(order.isEmpty())
            throw new OrderNotFoundException(id);
        return order.get();
    }

    public String addOrder(Orders order) throws CustomerNotFoundException, ShipperNotFoundException {
        Optional<Customers> customer = customerRepository.findById(order.getCustomer().getCustomerId());
        Optional<Shippers> shipper = shipperRepository.findById(order.getShipper().getShipperId());
        if(customer.isEmpty())
            throw new CustomerNotFoundException(order.getCustomer().getCustomerId());
        if(shipper.isEmpty())
            throw new ShipperNotFoundException(order.getShipper().getShipperId());
        orderRepository.save(order);
        return "Added!!";
    }
}
