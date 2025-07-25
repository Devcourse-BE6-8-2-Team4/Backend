package com.team04.back.domain.cloth.cloth.controller;

import com.team04.back.domain.cloth.cloth.service.ClothService;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/cloth")
@RequiredArgsConstructor
public class ClothController {
    private final ClothService clothService;


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
