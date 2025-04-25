package com.example.crud.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no debe estar vacio")
    @Size(min = 3,max = 255,message = "El  nombre debe tener una rango de entre 3 a 255 caracteres")
    @Column(nullable = false,length = 255)
    private String name;

    @NotBlank(message = "La descripcion no debe estar vacia")
    @Size(min = 5, max = 300, message = "La descripcion debe contener entre 5 y 300 caracteres")
    @Column(nullable = false,length = 300)
    private String description;
    @Column(nullable = false)
    @NotNull(message = "El precio no debe ser nulo")
    @DecimalMin(value = "0.0", inclusive = false,message = "El precio debe ser mayor que 0")
    private Double price;
    public ProductEntity(){

    }

    public ProductEntity(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
