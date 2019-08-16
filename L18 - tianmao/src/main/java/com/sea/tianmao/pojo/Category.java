package com.sea.tianmao.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})//json虚拟化时排除的字段
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
}
