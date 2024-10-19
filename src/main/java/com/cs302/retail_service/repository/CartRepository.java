package com.cs302.retail_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs302.retail_service.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
