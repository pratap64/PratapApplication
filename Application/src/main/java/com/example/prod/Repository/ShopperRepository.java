package com.example.prod.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prod.Entity.Shopper;

@Repository
public interface ShopperRepository  extends JpaRepository<Shopper, Long> {

	
}
