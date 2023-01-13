package com.solverscrum.shopping.service;

import com.solverscrum.shopping.entity.OrderDetail;
import com.solverscrum.shopping.entity.Products;
import com.solverscrum.shopping.vo.OrderDetailsVo;
import org.springframework.stereotype.Service;
//annotations java 5
@Service
public class OrderDetailsService {

    public static OrderDetail convertToOrderDetail(OrderDetailsVo orderDetailsVo){
        OrderDetail orderDetail = new OrderDetail();
        Products product = new Products();
        product.setProductId(orderDetailsVo.getProductId());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());

        return orderDetail;
    }

    static OrderDetailsVo convertToOrderDetailsVo(OrderDetail orderDetails){
        OrderDetailsVo orderDetailsVo = new OrderDetailsVo();
        orderDetailsVo.setOrderDetailsId(orderDetails.getOrderDetailsId());
        orderDetailsVo.setQuantity(orderDetails.getQuantity());
        orderDetailsVo.setProductVo(ProductService.convertToProductVo(orderDetails.getProduct()));
        return orderDetailsVo;
    }
}


