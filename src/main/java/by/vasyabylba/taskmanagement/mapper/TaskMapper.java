package by.vasyabylba.taskmanagement.mapper;

import by.vasyabylba.taskmanagement.dto.TaskRequest;
import by.vasyabylba.taskmanagement.dto.TaskResponse;
import by.vasyabylba.taskmanagement.model.Task;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "priority", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    Task toTask(TaskRequest taskResponse);

    @InheritConfiguration(name = "toTask")
    Task partialUpdate(TaskRequest taskRequest, @MappingTarget Task task);

    @Mapping(source = "status.name", target = "status")
    @Mapping(source = "priority.name", target = "priority")
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "assignee.id", target = "assigneeId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    TaskResponse toTaskResponse(Task task);
}