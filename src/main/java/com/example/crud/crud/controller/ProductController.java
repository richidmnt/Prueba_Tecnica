package com.example.crud.crud.controller;

import com.example.crud.crud.entity.ProductEntity;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud.crud.service.ProductServiceImp;

import java.util.List;
import java.util.Optional;

@RestController

public class ProductController {
    private ProductServiceImp productServiceImp;
    public ProductController(ProductServiceImp productServiceImp){
        this.productServiceImp = productServiceImp;
    }
    @GetMapping("/")
    public String message(){
        return "hola mundo";
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id){

        return ResponseEntity.ok(productServiceImp.findById(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImp.findByAll());
    }

    @PostMapping("/product")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productSave){
        ProductEntity productNew = productServiceImp.saveProduct(productSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productServiceImp.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("product/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id,@RequestBody ProductEntity productEntity){
        return ResponseEntity.status(HttpStatus.OK).body(productServiceImp.updateProduct(id,productEntity));

    }

}
