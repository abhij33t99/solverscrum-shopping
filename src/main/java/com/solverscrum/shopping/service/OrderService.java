package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.entity.OrderDetails;
import com.solverscrum.shopping.entity.Orders;
import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.exceptions.OrderNotFoundException;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.repository.OrderDetailsRepository;
import com.solverscrum.shopping.repository.OrderRepository;
import com.solverscrum.shopping.repository.ShipperRepository;
import com.solverscrum.shopping.vo.OrderDetailsVo;
import com.solverscrum.shopping.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
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

    public String addOrder(OrderVo orderVo) throws CustomerNotFoundException, ShipperNotFoundException {
        Orders order = convertToOrders(orderVo);
        Optional<Customers> customer = customerRepository.findById(order.getCustomer().getCustomerId());
        Optional<Shippers> shipper = shipperRepository.findById(order.getShipper().getShipperId());
        if(customer.isEmpty())
            throw new CustomerNotFoundException(order.getCustomer().getCustomerId());
        if(shipper.isEmpty())
            throw new ShipperNotFoundException(order.getShipper().getShipperId());
        orderRepository.save(order);

        return "Added!!";
    }

    static Orders convertToOrders(OrderVo orderVo){
        Orders order = new Orders();
        order.setOrderDate(orderVo.getOrderDate());
        Customers customers = new Customers();
        customers.setCustomerId(orderVo.getCustomerId());
        order.setCustomer(customers);
        Shippers shippers = new Shippers();
        shippers.setShipperId(orderVo.getShipperId());
        order.setShipper(shippers);
        List<OrderDetails> orderDetails = new ArrayList<>(); // Generics
        for(OrderDetailsVo orderDetailsVo : orderVo.getOrderDetailsVo()){ //for-each
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);

        return order;
    }
}
