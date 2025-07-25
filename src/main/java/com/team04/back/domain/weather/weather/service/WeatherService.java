package com.team04.back.domain.weather.weather.service;

import com.team04.back.domain.weather.weather.dto.WeatherDto;
import org.springframework.stereotype.Service;
import com.team04.back.domain.weather.weather.enums.Weather;

import java.time.LocalDateTime;

@Service
public class WeatherService {

    public WeatherDto getWeatherByCoordinates(double latitude, double longitude) {
        //dummy data - 추후 API 연동 필요
        // 실제 API를 통해 날씨 정보를 가져오는 로직을 구현해야 함
        Weather weather;
        WeatherDto weatherDto = new WeatherDto(1, weather.SUNNY, 25.0, 30.0, 20.0, "서울", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
        return weatherDto;
    }
}
