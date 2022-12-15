package com.solverscrum.shopping.repository;

import com.solverscrum.shopping.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
}
