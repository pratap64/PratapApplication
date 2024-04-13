package com.example.prod.Repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prod.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByShopperIdAndCategoryAndBrand(Long shopperId, String category, String brand);
	List<Product> findByShopperId(String shopperId, PageRequest pageRequest);

	List<Product> findByShopperIdAndCategory(String shopperId, String category, PageRequest pageRequest);

	List<Product> findByShopperIdAndBrand(String shopperId, String brand, PageRequest pageRequest);

	List<Product> findByShopperIdAndCategoryAndBrand(String shopperId, String category, String brand,
			PageRequest pageRequest);

	    List<Product> findByShopperId(Long shopperId);
	

	
}

