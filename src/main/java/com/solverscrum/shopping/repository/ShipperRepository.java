package com.solverscrum.shopping.repository;

import com.solverscrum.shopping.entity.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shippers, Integer> {
}
