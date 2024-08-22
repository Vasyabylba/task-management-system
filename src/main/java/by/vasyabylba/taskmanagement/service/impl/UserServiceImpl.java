package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.UserRequest;
import by.vasyabylba.taskmanagement.dto.UserResponse;
import by.vasyabylba.taskmanagement.mapper.UserMapper;
import by.vasyabylba.taskmanagement.model.User;
import by.vasyabylba.taskmanagement.repository.UserRepository;
import by.vasyabylba.taskmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getOne(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
        userRequest.setPassword(encodedPassword);
        User user = userMapper.toUser(userRequest);
        User resultUser = userRepository.save(user);
        return userMapper.toUserResponse(resultUser);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        if (userRequest.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
            userRequest.setPassword(encodedPassword);
        }
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
