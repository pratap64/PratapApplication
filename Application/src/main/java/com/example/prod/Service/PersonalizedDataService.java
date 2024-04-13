package com.example.prod.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.prod.Entity.Product;
import com.example.prod.Entity.Shopper;
import com.example.prod.Repository.ProductRepository;
import com.example.prod.Repository.ShopperRepository;

@Service
public class PersonalizedDataService {

    private final ShopperRepository shopperRepository;
    private final ProductRepository productRepository;

    @Autowired
    public PersonalizedDataService(ShopperRepository shopperRepository, ProductRepository productRepository) {
        this.shopperRepository = shopperRepository;
        this.productRepository = productRepository;
    }

    public Shopper saveShopper(Shopper shopper) {
        return shopperRepository.save(shopper);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductsByShopperId(String shopperId, PageRequest pageRequest) {
        return productRepository.findByShopperId(shopperId, pageRequest);
    }

    public List<Product> getProductsByShopperIdAndCategory(String shopperId, String category, PageRequest pageRequest) {
        return productRepository.findByShopperIdAndCategory(shopperId, category, pageRequest);
    }

    public List<Product> getProductsByShopperIdAndBrand(String shopperId, String brand, PageRequest pageRequest) {
        return productRepository.findByShopperIdAndBrand(shopperId, brand, pageRequest);
    }

    public List<Product> getProductsByShopperIdAndCategoryAndBrand(String shopperId, String category, String brand, PageRequest pageRequest) {
        return productRepository.findByShopperIdAndCategoryAndBrand(shopperId, category, brand, pageRequest);
    }
    
    public List<Product> getProductsByShopperId(Long shopperId) {
        return productRepository.findByShopperId(shopperId);
    }
}
