package by.vasyabylba.taskmanagement.service.impl;

import by.vasyabylba.taskmanagement.dto.CommentRequest;
import by.vasyabylba.taskmanagement.dto.CommentResponse;
import by.vasyabylba.taskmanagement.mapper.CommentMapper;
import by.vasyabylba.taskmanagement.model.Comment;
import by.vasyabylba.taskmanagement.model.User;
import by.vasyabylba.taskmanagement.repository.CommentRepository;
import by.vasyabylba.taskmanagement.repository.UserRepository;
import by.vasyabylba.taskmanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public CommentResponse getOne(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public CommentResponse create(CommentRequest commentRequest) {
        Comment comment = commentMapper.toComment(commentRequest);

        setAssociations(commentRequest, comment);

        Comment resultComment = commentRepository.save(comment);
        return commentMapper.toCommentResponse(resultComment);
    }

    @Override
    public CommentResponse update(Long id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id).orElseThrow();

        Comment updated = commentMapper.partialUpdate(commentRequest, comment);
        setAssociations(commentRequest, updated);

        Comment resultComment = commentRepository.save(updated);
        return commentMapper.toCommentResponse(resultComment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentResponse> getList() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapper::toCommentResponse)
                .toList();
    }

    private void setAssociations(CommentRequest commentRequest, Comment comment) {
        User author = null;
        if (commentRequest.getAuthorId() != null) {
            author = userRepository.findById(commentRequest.getAuthorId()).orElseThrow();
        }
        comment.setAuthor(author);
    }
}
