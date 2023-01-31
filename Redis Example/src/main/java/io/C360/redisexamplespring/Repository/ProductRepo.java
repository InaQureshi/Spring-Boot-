package io.C360.redisexamplespring.Repository;

import io.C360.redisexamplespring.entity.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class ProductRepo {

    public static final String HASH_KEY= "Products";
    @Autowired
    private RedisTemplate redisTemplate;
    public Products save(Products products)
    {
        redisTemplate.opsForHash().put("Products",products.getId(),products);
        return products;
    }

    public List<Products> findAll()
    {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }
    public Products findProductByID(int id)
    {
        System.out.println("called findProductById() from DB");
        return (Products) redisTemplate.opsForHash().get(HASH_KEY,id);
  }
    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }


}
