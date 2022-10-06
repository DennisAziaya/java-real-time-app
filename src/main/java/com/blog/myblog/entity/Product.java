package com.blog.myblog.entity;

import com.blog.myblog.entity.enums.ProductType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    ProductType productType;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy ="'product'")
//    private Set<Purchase> purchaseList;

}
