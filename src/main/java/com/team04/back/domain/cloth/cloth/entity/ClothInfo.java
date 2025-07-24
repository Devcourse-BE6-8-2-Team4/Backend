package com.team04.back.domain.cloth.cloth.entity;

import com.team04.back.domain.cloth.cloth.enums.Category;
import com.team04.back.domain.weather.weather.enums.Weather;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

public class ClothInfo {
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