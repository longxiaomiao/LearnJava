package com.sea.tianmao.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "product")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
    private Date createDate;

    @Transient //表示该属性并非一个到数据库表的字段的映射
    private ProductImage firstProductImage;
}
