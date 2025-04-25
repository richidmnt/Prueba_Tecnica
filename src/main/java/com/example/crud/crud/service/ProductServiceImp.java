package com.example.crud.crud.service;

import com.example.crud.crud.entity.ProductEntity;
import com.example.crud.crud.exception.BusinnesException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.crud.crud.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp {
    private final ProductRepository productRepository;
    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public ProductEntity findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new BusinnesException("NO se encontró el usuario", HttpStatus.NOT_FOUND, "d500"));
    }
    public ProductEntity findByName(String name){
        return productRepository.findByName(name).orElseThrow(()->new BusinnesException("no se pudo encontrar el producto",HttpStatus.NOT_FOUND,"d480"));
    }
    public List<ProductEntity> findByAll(){
        try{
            return productRepository.findAll();
        }catch (Exception e){
            throw  new RuntimeException("No se encontro ningun usuario con ese nombre"+e.getMessage());
        }
    }
    public ProductEntity saveProduct(ProductEntity productEntity){
        try{
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el usuario"+e.getMessage());
        }
    }
    public void deleteProduct(Long id){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        productRepository.delete(product);

    }
    @Transactional
    public ProductEntity updateProduct(Long id,ProductEntity productEntity){

            ProductEntity productUpdate = productRepository.findById(id).orElseThrow(()->new RuntimeException("No se pudo encontrar el producto" + id));
            productUpdate.setName(productEntity.getName());
            productUpdate.setDescription(productEntity.getDescription());
            productUpdate.setPrice(productEntity.getPrice());
            productRepository.save(productUpdate);
            return productUpdate;
    }


}
