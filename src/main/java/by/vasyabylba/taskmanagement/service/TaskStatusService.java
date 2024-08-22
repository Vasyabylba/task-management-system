package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.TaskStatusRequest;
import by.vasyabylba.taskmanagement.dto.TaskStatusResponse;

import java.util.List;

public interface TaskStatusService {
    TaskStatusResponse getOne(Long id);

    TaskStatusResponse create(TaskStatusRequest taskStatusRequest);

    TaskStatusResponse update(Long id, TaskStatusRequest taskStatusRequest);

    void delete(Long id);

    List<TaskStatusResponse> getList();
}
