package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.OrderDetails;
import com.solverscrum.shopping.entity.Orders;
import com.solverscrum.shopping.entity.Products;
import com.solverscrum.shopping.vo.OrderDetailsVo;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {

    public static OrderDetails convertToOrderDetail(OrderDetailsVo orderDetailsVo){
        OrderDetails orderDetail = new OrderDetails();
        Products product = new Products();
        product.setProductId(orderDetailsVo.getProductId());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());

        return orderDetail;
    }
}

//order = new order();
//order.add(new orderDetails());
