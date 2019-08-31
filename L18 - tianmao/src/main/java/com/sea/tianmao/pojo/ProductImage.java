package com.sea.tianmao.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sea.tianmao.pojo.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "productimage")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pid")
    @JsonBackReference
    private Product product;

    private String type;
}
