package by.vasyabylba.taskmanagement.contoller;

import by.vasyabylba.taskmanagement.dto.UserRequest;
import by.vasyabylba.taskmanagement.dto.UserResponse;
import by.vasyabylba.taskmanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get user by id")
    @GetMapping("/{id}")
    public UserResponse getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserResponse> getList() {
        return userService.getList();
    }

    @Operation(summary = "Create user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @Operation(summary = "Update user by id")
    @PutMapping("/{id}")
    @PreAuthorize(value = "@userService.getOne(#id).getEmail() == authentication.name")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "@userService.getOne(#id).getEmail() == authentication.name")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

