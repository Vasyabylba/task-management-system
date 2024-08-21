package by.vasyabylba.taskmanagement.service;

import by.vasyabylba.taskmanagement.dto.UserRequest;
import by.vasyabylba.taskmanagement.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse getOne(Long id);

    UserResponse create(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);

    List<UserResponse> getList();
}
