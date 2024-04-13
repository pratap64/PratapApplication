package com.example.prod.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.prod.Entity.Product;
import com.example.prod.Entity.Shopper;
import com.example.prod.Service.PersonalizedDataService;

@RestController
@RequestMapping("/api/internal")
public class InternalApiController {

    private final PersonalizedDataService personalizedDataService;

    @Autowired
    public InternalApiController(PersonalizedDataService personalizedDataService) {
        this.personalizedDataService = personalizedDataService;
    }

    @PostMapping("/personalized-list")
    public Shopper saveShopper(@RequestBody Shopper shopper) {
        return personalizedDataService.saveShopper(shopper);
    }

    @PostMapping("/product-metadata")
    public Product saveProduct(@RequestBody Product product) {
        return personalizedDataService.saveProduct(product);
    }
}
