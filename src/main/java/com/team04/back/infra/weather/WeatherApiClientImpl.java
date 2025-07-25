package com.team04.back.infra.weather;

import com.team04.back.infra.weather.dto.OneCallApiResponse;
import com.team04.back.infra.weather.dto.TimeMachineApiResponse;
import com.team04.back.infra.weather.dto.DaySummaryApiResponse;
import com.team04.back.infra.weather.dto.WeatherOverviewApiResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WeatherApiClientImpl implements WeatherApiClient {

    private final WebClient webClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    @Override
    public Mono<OneCallApiResponse> fetchOneCallWeatherData(@NotNull double lat, @NotNull double lon, List<String> exclude, String units, String lang) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/3.0/onecall")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("exclude", String.join(",", exclude))
                        .queryParam("units", units)
                        .queryParam("lang", lang)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(OneCallApiResponse.class);
    }

    @Override
    public Mono<TimeMachineApiResponse> fetchTimeMachineWeatherData(@NotNull double lat, @NotNull double lon, @NotNull long dt, String units, String lang) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/3.0/onecall/timemachine")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("dt", dt)
                        .queryParam("units", units)
                        .queryParam("lang", lang)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(TimeMachineApiResponse.class);
    }

    @Override
    public Mono<DaySummaryApiResponse> fetchDaySummaryWeatherData(@NotNull double lat, @NotNull double lon, @NotNull String date, String tz, String units) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/3.0/onecall/day_summary")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("date", date)
                        .queryParam("tz", tz)
                        .queryParam("units", units)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(DaySummaryApiResponse.class);
    }

    @Override
    public Mono<WeatherOverviewApiResponse> fetchWeatherOverview(@NotNull double lat, @NotNull double lon, String date, String units) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/3.0/onecall/overview")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("date", date)
                        .queryParam("units", units)
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(WeatherOverviewApiResponse.class);
    }
}
