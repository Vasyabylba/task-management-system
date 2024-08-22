package by.vasyabylba.taskmanagement.contoller;

import by.vasyabylba.taskmanagement.dto.TaskStatusRequest;
import by.vasyabylba.taskmanagement.dto.TaskStatusResponse;
import by.vasyabylba.taskmanagement.service.TaskStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TaskStatus")
@RestController
@RequestMapping(value = "/api/task_statuses", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskStatusController {
    private final TaskStatusService statusService;

    @Operation(summary = "Get status by id")
    @GetMapping("/{id}")
    public TaskStatusResponse getOne(@PathVariable Long id) {
        return statusService.getOne(id);
    }

    @Operation(summary = "Get all statuses")
    @GetMapping
    public List<TaskStatusResponse> getList() {
        return statusService.getList();
    }

    @Operation(summary = "Create status")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskStatusResponse create(@RequestBody @Valid TaskStatusRequest taskStatusRequest) {
        return statusService.create(taskStatusRequest);
    }

    @Operation(summary = "Update status by id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskStatusResponse update(@PathVariable Long id, @RequestBody @Valid TaskStatusRequest taskStatusRequest) {
        return statusService.update(id, taskStatusRequest);
    }

    @Operation(summary = "Delete status by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        statusService.delete(id);
    }
}

