package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.TaskPriorityRequest;
import by.vasyabylba.taskmanagement.dto.TaskPriorityResponse;

import java.util.List;

public interface TaskPriorityService {
    TaskPriorityResponse getOne(Long id);

    TaskPriorityResponse create(TaskPriorityRequest taskPriorityRequest);

    TaskPriorityResponse update(Long id, TaskPriorityRequest taskPriorityRequest);

    void delete(Long id);

    List<TaskPriorityResponse> getList();
}
