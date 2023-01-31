package io.C360.redisexamplespring.Controller;

import io.C360.redisexamplespring.Repository.ProductRepo;
import io.C360.redisexamplespring.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
@EnableCaching
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    @PostMapping
    public Products save(@RequestBody Products products)
    {
        return productRepo.save(products);
    }
    @GetMapping
    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Products")
    public Products findProduct(@PathVariable int id) {
        return productRepo.findProductByID(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Products")
    public String remove(@PathVariable int id) {
        return productRepo.deleteProduct(id);
    }

}
