package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.dto.TaskRequest;
import by.vasyabylba.taskmanagement.dto.TaskResponse;
import by.vasyabylba.taskmanagement.filter.TaskFilter;
import by.vasyabylba.taskmanagement.mapper.CommentMapper;
import by.vasyabylba.taskmanagement.mapper.TaskMapper;
import by.vasyabylba.taskmanagement.model.Task;
import by.vasyabylba.taskmanagement.model.TaskPriority;
import by.vasyabylba.taskmanagement.model.TaskStatus;
import by.vasyabylba.taskmanagement.model.User;
import by.vasyabylba.taskmanagement.repository.TaskPriorityRepository;
import by.vasyabylba.taskmanagement.repository.TaskRepository;
import by.vasyabylba.taskmanagement.repository.TaskStatusRepository;
import by.vasyabylba.taskmanagement.repository.UserRepository;
import by.vasyabylba.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final CommentMapper commentMapper;

    private final TaskRepository taskRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final TaskPriorityRepository taskPriorityRepository;
    private final UserRepository userRepository;

    @Override
    public TaskResponse getOne(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public TaskResponse create(TaskRequest taskRequest) {
        Task task = taskMapper.toTask(taskRequest);

        setAssociations(taskRequest, task);

        Task resultTask = taskRepository.save(task);
        return taskMapper.toTaskResponse(resultTask);
    }

    @Override
    public TaskResponse update(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id).orElseThrow();

        Task updated = taskMapper.partialUpdate(taskRequest, task);
        setAssociations(taskRequest, updated);

        Task resultTask = taskRepository.save(updated);
        return taskMapper.toTaskResponse(resultTask);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Page<TaskResponse> getList(TaskFilter filter, Pageable pageable) {
        Specification<Task> spec = filter.toSpecification();
        Page<Task> tasks = taskRepository.findAll(spec, pageable);
        return tasks.map(taskMapper::toTaskResponse);
    }

    @Override
    public List<CommentResponse> getComments(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        return task.getComments().stream()
                .map(commentMapper::toCommentResponse)
                .toList();
    }

    private void setAssociations(TaskRequest taskRequest, Task task) {
        TaskStatus status = null;
        if (taskRequest.getStatus() != null) {
            status = taskStatusRepository.findByNameIgnoreCase(taskRequest.getStatus()).orElseThrow();
        }
        TaskPriority priority = null;
        if (taskRequest.getPriority() != null) {
            priority = taskPriorityRepository.findByNameIgnoreCase(taskRequest.getPriority()).orElseThrow();
        }
        User author = null;
        if (taskRequest.getAuthorId() != null) {
            author = userRepository.findById(taskRequest.getAuthorId()).orElseThrow();
        }
        User assignee = null;
        if (taskRequest.getAssigneeId() != null) {
            assignee = userRepository.findById(taskRequest.getAssigneeId()).orElseThrow();
        }
        task.setStatus(status);
        task.setPriority(priority);
        task.setAuthor(author);
        task.setAssignee(assignee);
    }
}
