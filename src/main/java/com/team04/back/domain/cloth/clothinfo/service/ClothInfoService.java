package com.team04.back.domain.cloth.clothinfo.service;

import com.team04.back.domain.cloth.clothinfo.repository.ClothInfoRepository;
import com.team04.back.domain.weather.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClothInfoService {
    private final ClothInfoRepository clothInfoRepository;
    private final WeatherRepository weatherRepository;

    public void getOutfitWithPeriod(String place, LocalDate start, LocalDate end) {
        //1. 단 기간에 해당하는 날씨정보 조회
//        weatherRepository.findByLocationAndDateBetween(place, start, end);
                //  1.만약 업데이트 시간이 1시간이 넘어갔거나 날씨 정보가 없다면 API재요청을 통해 날씨 정보를 업데이트한다


        //2. 기간의 각 일자별(일별 평균 체감기온 기준) 상의, 하의를 조회한다. 상/하의는 각각 최소 1개 이상이어야한다.
        //  2.1 아우터도 검색한다. 아우터는 0개 이상이어야한다.
        //3.일자별 기상상태에 따라 추가물품이 필요하다 판단되면 추가 물품(ExtraCloth)을 조회한다
        //  3.1 추가물품은 기상 상태별1개 이상이어야 한다.
    }
}
