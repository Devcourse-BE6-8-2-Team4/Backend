package com.team04.back.domain.cloth.clothinfo.entity;

import com.team04.back.domain.cloth.clothinfo.enums.Category;
import jakarta.persistence.*;

@Entity
public class ClothInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String clothName;

    @Column(nullable = false)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Double maxFeelsLike;

    @Column(nullable = false)
    private Double minFeelsLike;
}