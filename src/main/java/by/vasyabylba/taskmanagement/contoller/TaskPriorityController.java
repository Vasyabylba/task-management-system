package by.vasyabylba.taskmanagement.contoller;

import by.vasyabylba.taskmanagement.dto.TaskPriorityRequest;
import by.vasyabylba.taskmanagement.dto.TaskPriorityResponse;
import by.vasyabylba.taskmanagement.service.TaskPriorityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TaskPriority")
@RestController
@RequestMapping(value = "/api/task_priorities", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskPriorityController {
    private final TaskPriorityService priorityService;

    @Operation(summary = "Get priority by id")
    @GetMapping("/{id}")
    public TaskPriorityResponse getOne(@PathVariable Long id) {
        return priorityService.getOne(id);
    }

    @Operation(summary = "Get all priorities")
    @GetMapping
    public List<TaskPriorityResponse> getList() {
        return priorityService.getList();
    }

    @Operation(summary = "Create priority")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskPriorityResponse create(@RequestBody @Valid TaskPriorityRequest taskPriorityRequest) {
        return priorityService.create(taskPriorityRequest);
    }

    @Operation(summary = "Update priority by id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskPriorityResponse update(@PathVariable Long id, @RequestBody @Valid TaskPriorityRequest taskPriorityRequest) {
        return priorityService.update(id, taskPriorityRequest);
    }

    @Operation(summary = "Delete priority by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        priorityService.delete(id);
    }
}

