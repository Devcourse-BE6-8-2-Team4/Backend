package com.team04.back.domain.cloth.cloth.dto;

import java.util.List;

public record OutfitResponse(
        List<String> minRequiredItems,
        List<String> additionalConsiderItems
) {
}
