package com.team04.back.infra.weather;

import com.team04.back.infra.weather.dto.DaySummaryApiResponse;
import com.team04.back.infra.weather.dto.OneCallApiResponse;
import com.team04.back.infra.weather.dto.TimeMachineApiResponse;
import com.team04.back.infra.weather.dto.WeatherOverviewApiResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
class WeatherApiClientImplE2ETest {

    @Autowired
    private WeatherApiClient weatherApiClient;

    private final double TEST_LAT = 37.5665;
    private final double TEST_LON = 126.9780;
    private final String TEST_UNITS = "metric";
    private final String TEST_LANG = "kr";

    @DisplayName("One Call API - Current and forecasts weather data 호출 테스트")
    @Test
    void testFetchOneCallWeatherData() {
        List<String> exclude = Arrays.asList("minutely", "hourly", "daily", "alerts");
        Mono<OneCallApiResponse> responseMono = weatherApiClient.fetchOneCallWeatherData(
                TEST_LAT, TEST_LON, exclude, TEST_UNITS, TEST_LANG
        );

        OneCallApiResponse response = responseMono.block();

        assertNotNull(response);
        assertNotNull(response.getCurrent());
        System.out.println("One Call API Response: " + response.getCurrent().getTemp() + " " + response.getCurrent().getWeather().get(0).getDescription());
    }

    @DisplayName("One Call API - Weather data for timestamp API 호출 테스트")
    @Test
    void testFetchTimeMachineWeatherData() {
        long dt = LocalDate.of(2023, 1, 1).atStartOfDay().toEpochSecond(ZoneOffset.UTC);

        Mono<TimeMachineApiResponse> responseMono = weatherApiClient.fetchTimeMachineWeatherData(
                TEST_LAT, TEST_LON, dt, TEST_UNITS, TEST_LANG
        );

        TimeMachineApiResponse response = responseMono.block();

        assertNotNull(response);
        assertNotNull(response.getData());
        assertTrue(response.getData().size() > 0);
        System.out.println("Time Machine API Response: " + response.getData().get(0).getTemp() + " " + response.getData().get(0).getWeather().get(0).getDescription());
    }

    @DisplayName("One Call API - Daily Aggregation API 호출 테스트")
    @Test
    void testFetchDaySummaryWeatherData() {
        String date = "2023-03-30";
        String tz = "+09:00";

        Mono<DaySummaryApiResponse> responseMono = weatherApiClient.fetchDaySummaryWeatherData(
                TEST_LAT, TEST_LON, date, tz, TEST_UNITS
        );

        DaySummaryApiResponse response = responseMono.block();

        assertNotNull(response);
        assertNotNull(response.getTemperature());
        System.out.println("Day Summary API Response: Min Temp: " + response.getTemperature().getMin() + ", Max Temp: " + response.getTemperature().getMax());
    }

    @DisplayName("One Call API - Weather Overview API 호출 테스트")
    @Test
    void testFetchWeatherOverview() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Mono<WeatherOverviewApiResponse> responseMono = weatherApiClient.fetchWeatherOverview(
                TEST_LAT, TEST_LON, date, TEST_UNITS
        );

        WeatherOverviewApiResponse response = responseMono.block();

        assertNotNull(response);
        assertNotNull(response.getWeatherOverview());
        assertTrue(response.getWeatherOverview().length() > 0);
        System.out.println("Weather Overview API Response: " + response.getWeatherOverview());
    }
}
