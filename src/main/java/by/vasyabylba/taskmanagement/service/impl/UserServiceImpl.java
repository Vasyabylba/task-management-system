package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.UserRequest;
import by.vasyabylba.taskmanagement.dto.UserResponse;
import by.vasyabylba.taskmanagement.mapper.UserMapper;
import by.vasyabylba.taskmanagement.model.User;
import by.vasyabylba.taskmanagement.repository.UserRepository;
import by.vasyabylba.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UserResponse getOne(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        int hashCode = userRequest.getPassword().hashCode();
        userRequest.setPassword(String.valueOf(hashCode));
        User user = userMapper.toUser(userRequest);
        User resultUser = userRepository.save(user);
        return userMapper.toUserResponse(resultUser);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow();
        User updated = userMapper.partialUpdate(userRequest, user);
        User resultUser = userRepository.save(updated);
        return userMapper.toUserResponse(resultUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> getList() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserResponse)
                .toList();
    }
}
