package by.vasyabylba.taskmanagement.mapper;

import by.vasyabylba.taskmanagement.dto.UserRequest;
import by.vasyabylba.taskmanagement.dto.UserResponse;
import by.vasyabylba.taskmanagement.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRequest userRequest, @MappingTarget User user);
}