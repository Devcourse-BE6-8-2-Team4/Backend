package com.team04.back.domain.comment.comment.entity;

import jakarta.persistence.*;

@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private String imageUrl;

    @Column(nullable = false)
    private String sentence;

    @Column(nullable = false)
    private String tagString;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_info_id", nullable = false)
    private WeatherInfo weatherInfo;
}
