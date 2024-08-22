package by.vasyabylba.taskmanagement.mapper;

import by.vasyabylba.taskmanagement.dto.TaskStatusRequest;
import by.vasyabylba.taskmanagement.dto.TaskStatusResponse;
import by.vasyabylba.taskmanagement.model.TaskStatus;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskStatusMapper {
    TaskStatus toTaskStatus(TaskStatusRequest taskStatusRequest);

    TaskStatusResponse toTaskStatusResponse(TaskStatus taskStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskStatus partialUpdate(TaskStatusRequest taskStatusRequest, @MappingTarget TaskStatus taskStatus);
}