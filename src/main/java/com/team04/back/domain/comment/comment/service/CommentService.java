package com.team04.back.domain.comment.comment.service;

import com.team04.back.domain.comment.comment.entity.Comment;
import com.team04.back.domain.comment.comment.repository.CommentRepository;
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
}
