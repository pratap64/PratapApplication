package com.example.prod.Controller;

import org.hibernate.service.internal.ProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prod.Entity.Product;
import com.example.prod.Entity.Shopper;
import com.example.prod.Repository.ProductRepository;
import com.example.prod.Repository.ShopperRepository;
import com.example.prod.Service.PersonalizedDataService;

import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    private final PersonalizedDataService personalizedDataService;

    @Autowired
    public ExternalApiController(PersonalizedDataService personalizedDataService) {
        this.personalizedDataService = personalizedDataService;
    }
    
    @GetMapping("/products")
    public List<Product> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        List<Product> products;

        // If category and brand are both null, fetch all products for the given shopperId
        if (category == null && brand == null) {
            products = personalizedDataService.getProductsByShopperId(shopperId, PageRequest.of(0, limit));
        } else {
            // If category is not null and brand is null, fetch products by category for the given shopperId
            if (category != null && brand == null) {
                products = personalizedDataService.getProductsByShopperIdAndCategory(shopperId, category, PageRequest.of(0, limit));
            }
            // If brand is not null and category is null, fetch products by brand for the given shopperId
            else if (brand != null && category == null) {
                products = personalizedDataService.getProductsByShopperIdAndBrand(shopperId, brand, PageRequest.of(0, limit));
            }
            // If both category and brand are not null, fetch products by category and brand for the given shopperId
            else {
                products = personalizedDataService.getProductsByShopperIdAndCategoryAndBrand(shopperId, category, brand, PageRequest.of(0, limit));
            }
        }

        return products;
    }
    
    


}