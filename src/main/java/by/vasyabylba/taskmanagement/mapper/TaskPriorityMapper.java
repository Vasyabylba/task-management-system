package by.vasyabylba.taskmanagement.mapper;

import by.vasyabylba.taskmanagement.dto.TaskPriorityRequest;
import by.vasyabylba.taskmanagement.dto.TaskPriorityResponse;
import by.vasyabylba.taskmanagement.model.TaskPriority;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskPriorityMapper {
    TaskPriority toTaskPriority(TaskPriorityRequest taskPriorityRequest);

    TaskPriorityResponse toTaskPriorityResponse(TaskPriority taskPriority);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskPriority partialUpdate(TaskPriorityRequest taskPriorityRequest, @MappingTarget TaskPriority taskPriority);
}