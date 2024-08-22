package by.vasyabylba.taskmanagement.contoller;

import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.dto.TaskRequest;
import by.vasyabylba.taskmanagement.dto.TaskResponse;
import by.vasyabylba.taskmanagement.filter.TaskFilter;
import by.vasyabylba.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task")
@RestController
@RequestMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Get task by id")
    @GetMapping("/{id}")
    public TaskResponse getOne(@PathVariable Long id) {
        return taskService.getOne(id);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public Page<TaskResponse> getList(@ParameterObject @ModelAttribute TaskFilter filter,
                                      @ParameterObject Pageable pageable) {
        return taskService.getList(filter, pageable);
    }

    @Operation(summary = "Get comments by task id")
    @GetMapping("/{id}/comments")
    public List<CommentResponse> getComments(@PathVariable Long id) {
        return taskService.getComments(id);
    }

    @Operation(summary = "Create task")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse create(@RequestBody @Valid TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @Operation(summary = "Update task by id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse update(@PathVariable Long id, @RequestBody @Valid TaskRequest dto) {
        return taskService.update(id, dto);
    }

    @Operation(summary = "Delete task by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}

