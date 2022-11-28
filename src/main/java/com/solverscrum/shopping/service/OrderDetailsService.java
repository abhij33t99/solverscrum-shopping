package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.OrderDetails;
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

    static OrderDetailsVo convertToOrderDetailsVo(OrderDetails orderDetails){
        OrderDetailsVo orderDetailsVo = new OrderDetailsVo();
        orderDetailsVo.setOrderDetailsId(orderDetails.getOrderDetailsId());
        orderDetailsVo.setQuantity(orderDetails.getQuantity());
        orderDetailsVo.setProductVo(ProductService.convertToProductVo(orderDetails.getProduct()));
        return orderDetailsVo;
    }
}


