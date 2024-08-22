package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.CommentRequest;
import by.vasyabylba.taskmanagement.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse getOne(Long id);

    CommentResponse create(CommentRequest commentRequest);

    CommentResponse update(Long id, CommentRequest commentRequest);

    void delete(Long id);

    List<CommentResponse> getList();
}
