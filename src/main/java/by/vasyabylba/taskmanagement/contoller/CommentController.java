package by.vasyabylba.taskmanagement.contoller;

import by.vasyabylba.taskmanagement.dto.CommentRequest;
import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comment")
@RestController
@RequestMapping(value = "/api/comment", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "Get comment by id")
    @GetMapping("/{id}")
    public CommentResponse getOne(@PathVariable Long id) {
        return commentService.getOne(id);
    }

    @Operation(summary = "Get all comments")
    @GetMapping
    public List<CommentResponse> getList() {
        return commentService.getList();
    }

    @Operation(summary = "Create comment")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse create(@RequestBody @Valid CommentRequest commentRequest) {
        return commentService.create(commentRequest);
    }

    @Operation(summary = "Update comment by id")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentResponse update(@PathVariable Long id, @RequestBody @Valid CommentRequest commentRequest) {
        return commentService.update(id, commentRequest);
    }

    @Operation(summary = "Delete comment by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}

