package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.Customers;
import com.solverscrum.shopping.entity.OrderDetails;
import com.solverscrum.shopping.entity.Orders;
import com.solverscrum.shopping.entity.Shippers;
import com.solverscrum.shopping.exceptions.CustomerNotFoundException;
import com.solverscrum.shopping.exceptions.OrderNotFoundException;
import com.solverscrum.shopping.exceptions.ProductNotFoundException;
import com.solverscrum.shopping.exceptions.ShipperNotFoundException;
import com.solverscrum.shopping.repository.CustomerRepository;
import com.solverscrum.shopping.repository.OrderRepository;
import com.solverscrum.shopping.repository.ProductRepository;
import com.solverscrum.shopping.repository.ShipperRepository;
import com.solverscrum.shopping.vo.OrderDetailsVo;
import com.solverscrum.shopping.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ShipperRepository shipperRepository;
    @Autowired
    ProductRepository productRepository;

    private static ProductRepository staticProductRepository;

    @PostConstruct
    private void init(){
        staticProductRepository = productRepository;
    }

    public List<OrderVo> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderService::convertToOrderVo)
                .collect(Collectors.toList());
    }

    public OrderVo getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isEmpty())
            throw new OrderNotFoundException(id);
        return convertToOrderVo(order.get());
    }

    public String addOrder(OrderVo orderVo) throws CustomerNotFoundException, ShipperNotFoundException, ParseException, ProductNotFoundException {
        Optional<Customers> customer = customerRepository.findById(orderVo.getCustomerId());
        Optional<Shippers> shipper = shipperRepository.findById(orderVo.getShipperId());
        if (customer.isEmpty())
            throw new CustomerNotFoundException(orderVo.getCustomerId());
        if (shipper.isEmpty())
            throw new ShipperNotFoundException(orderVo.getShipperId());
        Orders order = convertToOrders(orderVo);
        orderRepository.save(order);

        return "Added!!";
    }

    static Orders convertToOrders(OrderVo orderVo) throws ParseException, ProductNotFoundException {
        Orders order = new Orders();
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(orderVo.getOrderDate()));
        Customers customers = new Customers();
        customers.setCustomerId(orderVo.getCustomerId());
        order.setCustomer(customers);
        Shippers shippers = new Shippers();
        shippers.setShipperId(orderVo.getShipperId());
        order.setShipper(shippers);
        List<OrderDetails> orderDetails = new ArrayList<>();
        for(OrderDetailsVo orderDetailsVo : orderVo.getOrderDetailsVo()){
            if(staticProductRepository.findById(orderDetailsVo.getProductId()).isEmpty())
                throw new ProductNotFoundException(orderDetailsVo.getProductId());
            orderDetails.add(OrderDetailsService.convertToOrderDetail(orderDetailsVo));
        }
        order.setOrderDetails(orderDetails);

        return order;
    }

    static OrderVo convertToOrderVo(Orders orders){
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orders.getOrderId());
        orderVo.setOrderDate(orders.getOrderDate().toString());
        orderVo.setCustomer(CustomerService.convertToCustomerVo(orders.getCustomer()));
        orderVo.setShipper(ShipperService.convertToShipperVo(orders.getShipper()));
        List<OrderDetailsVo> orderDetailsVos = orders.getOrderDetails()
                .stream()
                .map(OrderDetailsService::convertToOrderDetailsVo)
                .collect(Collectors.toList());
        orderVo.setOrderDetailsVo(orderDetailsVos);
        return orderVo;

    }
}
