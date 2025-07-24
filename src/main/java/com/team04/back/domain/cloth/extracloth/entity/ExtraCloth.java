package com.team04.back.domain.cloth.extracloth.entity;

import com.team04.back.domain.weather.weather.enums.Weather;
import jakarta.persistence.*;

@Entity
public class ExtraCloth{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String clothName;

    @Column(nullable = false)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Weather weather;
}