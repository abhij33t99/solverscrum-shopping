package com.solverscrum.shopping.repository;

import com.solverscrum.shopping.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {
}
