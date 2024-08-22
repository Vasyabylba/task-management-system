package by.vasyabylba.taskmanagement.mapper;

import by.vasyabylba.taskmanagement.dto.CommentRequest;
import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.model.Comment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Comment toComment(CommentRequest commentRequest);

    @Mapping(source = "author.id", target = "authorId")
    CommentResponse toCommentResponse(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment partialUpdate(CommentRequest commentRequest, @MappingTarget Comment comment);
}