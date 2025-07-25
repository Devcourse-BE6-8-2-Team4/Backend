package com.team04.back.domain.weather.weather.repository;

import com.team04.back.domain.weather.weather.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfo, Integer> {
}
