package com.sea.tianmao.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "uid")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    private String content;
    private Date createDate;
}
