package com.team04.back.domain.comment.comment.controller;

import com.team04.back.domain.comment.comment.dto.CommentDto;
import com.team04.back.domain.comment.comment.entity.Comment;
import com.team04.back.domain.comment.comment.service.CommentService;
import com.team04.back.domain.weather.weather.entity.WeatherInfo;
import com.team04.back.domain.weather.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final WeatherService weatherService;

    @GetMapping
    @Transactional(readOnly = true)
    public List<CommentDto> getComments() {
        List<Comment> items = commentService.findAll();

        return items.stream()
                .map(CommentDto::new)
                .toList();
    }

    @GetMapping("/search")
    @Transactional(readOnly = true)
    public List<CommentDto> getCommentsByLocationAndDate(
            @RequestParam String location,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ) {
        WeatherInfo weatherInfo = weatherService.findByLocationAndDate(location, date);
        List<Comment> items = commentService.findByWeatherInfo(weatherInfo);

        return items.stream()
                .map(CommentDto::new)
                .toList();
    }
}
