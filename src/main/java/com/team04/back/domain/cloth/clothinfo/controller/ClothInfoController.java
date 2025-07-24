package com.team04.back.domain.cloth.clothinfo.controller;

import com.team04.back.domain.cloth.clothinfo.service.ClothInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClothInfoController {
    private final ClothInfoService clothInfoService;

}
