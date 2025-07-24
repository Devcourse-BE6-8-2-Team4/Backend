package com.team04.back.domain.comment.comment.controller;

import com.team04.back.domain.comment.comment.entity.Comment;
import com.team04.back.domain.comment.comment.service.CommentService;
import com.team04.back.domain.weather.weather.entity.WeatherInfo;
import com.team04.back.domain.weather.weather.service.WeatherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CommentControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private CommentService commentService;
    @Autowired
    private WeatherService weatherService;

    @Test
    @DisplayName("커멘트 다건 조회")
    public void t1() throws Exception {
        ResultActions resultActions = mvc
                .perform(
                        get("api/v1/comments")
                ).andDo(print());

        List<Comment> comments = commentService.findAll();

        resultActions
                .andExpect(handler().handlerType(CommentController.class))
                .andExpect(handler().methodName("getComments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(comments.size()));

        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            resultActions
                    .andExpect(jsonPath("$[%d].id".formatted(i)).value(comment.getId()))
                    .andExpect(jsonPath("$[%d].email".formatted(i)).value(comment.getEmail()))
                    .andExpect(jsonPath("$[%d].imageUrl".formatted(i)).value(comment.getImageUrl()))
                    .andExpect(jsonPath("$[%d].sentence".formatted(i)).value(comment.getSentence()))
                    .andExpect(jsonPath("$[%d].tagString".formatted(i)).value(comment.getTagString()))
                    .andExpect(jsonPath("$[%d].weatherInfo.location".formatted(i)).value(comment.getWeatherInfo().getLocation()))
                    .andExpect(jsonPath("$[%d].weatherInfo.date".formatted(i)).value(comment.getWeatherInfo().getDate()))
                    .andExpect(jsonPath("$[%d].weatherInfo.weather".formatted(i)).value(comment.getWeatherInfo().getWeather()));
        }
    }

    @Test
    @DisplayName("커멘트 조건 검색")
    public void t2() throws Exception {
        ResultActions resultActions = mvc
                .perform(
                        get("api/v1/comments/search")
                                .param("location", "seoul")
                                .param("date", "2022-01-01")
                ).andDo(print());

        WeatherInfo weatherInfo = weatherService.findByLocationAndDate("seoul", "2022-01-01");
        List<Comment> comments = commentService.findByWeatherInfo(weatherInfo);

        resultActions
                .andExpect(handler().handlerType(CommentController.class))
                .andExpect(handler().methodName("getCommentsByLocationAndDate"))
                .andExpect(status().isOk());

        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            resultActions
                    .andExpect(jsonPath("$[%d].id".formatted(i)).value(comment.getId()))
                    .andExpect(jsonPath("$[%d].email".formatted(i)).value(comment.getEmail()))
                    .andExpect(jsonPath("$[%d].imageUrl".formatted(i)).value(comment.getImageUrl()))
                    .andExpect(jsonPath("$[%d].sentence".formatted(i)).value(comment.getSentence()))
                    .andExpect(jsonPath("$[%d].tagString".formatted(i)).value(comment.getTagString()))
                    .andExpect(jsonPath("$[%d].weatherInfo.location".formatted(i)).value(comment.getWeatherInfo().getLocation()))
                    .andExpect(jsonPath("$[%d].weatherInfo.date".formatted(i)).value(comment.getWeatherInfo().getDate()))
                    .andExpect(jsonPath("$[%d].weatherInfo.weather".formatted(i)).value(comment.getWeatherInfo().getWeather()));
        }
    }
}
