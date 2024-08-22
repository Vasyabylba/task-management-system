package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.dto.TaskRequest;
import by.vasyabylba.taskmanagement.dto.TaskResponse;
import by.vasyabylba.taskmanagement.filter.TaskFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    TaskResponse getOne(Long id);

    TaskResponse create(TaskRequest taskRequest);

    TaskResponse update(Long id, TaskRequest taskRequest);

    void delete(Long id);

    Page<TaskResponse> getList(TaskFilter filter, Pageable pageable);

    List<CommentResponse> getComments(Long taskId);
}
