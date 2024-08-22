package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.TaskStatusRequest;
import by.vasyabylba.taskmanagement.dto.TaskStatusResponse;
import by.vasyabylba.taskmanagement.mapper.TaskStatusMapper;
import by.vasyabylba.taskmanagement.model.TaskStatus;
import by.vasyabylba.taskmanagement.repository.TaskStatusRepository;
import by.vasyabylba.taskmanagement.service.TaskStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskStatusRepository statusRepository;
    private final TaskStatusMapper statusMapper;

    @Override
    public TaskStatusResponse getOne(Long id) {
        TaskStatus status = statusRepository.findById(id).orElseThrow();
        return statusMapper.toTaskStatusResponse(status);
    }

    @Override
    public TaskStatusResponse create(TaskStatusRequest statusRequest) {
        TaskStatus status = statusMapper.toTaskStatus(statusRequest);
        TaskStatus resultStatus = statusRepository.save(status);
        return statusMapper.toTaskStatusResponse(resultStatus);
    }

    @Override
    public TaskStatusResponse update(Long id, TaskStatusRequest statusRequest) {
        TaskStatus status = statusRepository.findById(id).orElseThrow();
        TaskStatus updatedStatus = statusMapper.partialUpdate(statusRequest, status);
        TaskStatus resultStatus = statusRepository.save(updatedStatus);
        return statusMapper.toTaskStatusResponse(resultStatus);
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public List<TaskStatusResponse> getList() {
        List<TaskStatus> statuses = statusRepository.findAll();
        return statuses.stream()
                .map(statusMapper::toTaskStatusResponse)
                .toList();
    }
}
