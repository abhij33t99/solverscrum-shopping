package com.solverscrum.shopping.repository;

import com.solverscrum.shopping.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {
}
