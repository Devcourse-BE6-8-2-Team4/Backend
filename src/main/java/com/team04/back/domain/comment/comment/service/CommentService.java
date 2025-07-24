package com.team04.back.domain.comment.comment.service;

import com.team04.back.domain.comment.comment.entity.Comment;
import com.team04.back.domain.comment.comment.repository.CommentRepository;
import com.team04.back.domain.weather.weather.entity.WeatherInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findByWeatherInfo(WeatherInfo weatherInfo) {
        return commentRepository.findByWeatherInfo(weatherInfo);
    }
}
