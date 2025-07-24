package com.team04.back.domain.cloth.clothinfo.controller;

import com.team04.back.domain.cloth.clothinfo.dto.OutfitResponse;
import com.team04.back.domain.cloth.clothinfo.service.ClothInfoService;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/cloth")
@RequiredArgsConstructor
public class ClothInfoController {
    private final ClothInfoService clothInfoService;


    record TripSchedule(
            @NotBlank
            String place,
            @NotBlank
            @PastOrPresent
            LocalDate start,
            @NotBlank
            @Future
            LocalDate end
    ) {
    }

//    @GetMapping
//    public OutfitResponse getOutfitWithPeriod(@ResponseBody TripSchedule tripSchedule) {
//        clothInfoService.getOutfitWithPeriod(
//                tripSchedule.place(),
//                tripSchedule.start(),
//                tripSchedule.end()
//        );
//        return null;
//    }

}
