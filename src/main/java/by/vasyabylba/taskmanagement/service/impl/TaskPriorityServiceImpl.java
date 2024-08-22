package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.TaskPriorityRequest;
import by.vasyabylba.taskmanagement.dto.TaskPriorityResponse;
import by.vasyabylba.taskmanagement.mapper.TaskPriorityMapper;
import by.vasyabylba.taskmanagement.model.TaskPriority;
import by.vasyabylba.taskmanagement.repository.TaskPriorityRepository;
import by.vasyabylba.taskmanagement.service.TaskPriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskPriorityServiceImpl implements TaskPriorityService {

    private final TaskPriorityRepository priorityRepository;
    private final TaskPriorityMapper priorityMapper;

    @Override
    public TaskPriorityResponse getOne(Long id) {
        TaskPriority status = priorityRepository.findById(id).orElseThrow();
        return priorityMapper.toTaskPriorityResponse(status);
    }

    @Override
    public TaskPriorityResponse create(TaskPriorityRequest statusRequest) {
        TaskPriority status = priorityMapper.toTaskPriority(statusRequest);
        TaskPriority resultPriority = priorityRepository.save(status);
        return priorityMapper.toTaskPriorityResponse(resultPriority);
    }

    @Override
    public TaskPriorityResponse update(Long id, TaskPriorityRequest statusRequest) {
        TaskPriority status = priorityRepository.findById(id).orElseThrow();
        TaskPriority updatedPriority = priorityMapper.partialUpdate(statusRequest, status);
        TaskPriority resultPriority = priorityRepository.save(updatedPriority);
        return priorityMapper.toTaskPriorityResponse(resultPriority);
    }

    @Override
    public void delete(Long id) {
        priorityRepository.deleteById(id);
    }

    @Override
    public List<TaskPriorityResponse> getList() {
        List<TaskPriority> statuses = priorityRepository.findAll();
        return statuses.stream()
                .map(priorityMapper::toTaskPriorityResponse)
                .toList();
    }
}
