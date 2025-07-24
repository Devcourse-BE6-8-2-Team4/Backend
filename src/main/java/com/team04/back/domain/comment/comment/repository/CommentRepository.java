package com.team04.back.domain.comment.comment.repository;

import com.team04.back.domain.comment.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("""
            SELECT c FROM Comment c
            WHERE c.weatherInfo.location = :location
            AND FUNCTION('month', c.weatherInfo.date) = :month
            """)
    List<Comment> findByWeatherInfoLocationAndMonth(@Param("location") String location, @Param("month") int month);
}
