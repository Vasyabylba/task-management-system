package by.vasyabylba.taskmanagement.filter;

import by.vasyabylba.taskmanagement.model.Task;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public record TaskFilter(Long assigneeId, Long authorId, String commentsContentContains) {
    public Specification<Task> toSpecification() {
        return Specification.where(assigneeIdSpec())
                .and(authorIdSpec())
                .and(commentsContentContainsSpec());
    }

    private Specification<Task> assigneeIdSpec() {
        return ((root, query, cb) -> assigneeId != null
                ? cb.equal(root.get("assignee").get("id"), assigneeId)
                : null);
    }

    private Specification<Task> authorIdSpec() {
        return ((root, query, cb) -> authorId != null
                ? cb.equal(root.get("author").get("id"), authorId)
                : null);
    }

    private Specification<Task> commentsContentContainsSpec() {
        return ((root, query, cb) -> StringUtils.hasText(commentsContentContains)
                ? cb.like(cb.lower(root.get("comments").get("content")), "%" + commentsContentContains.toLowerCase() + "%")
                : null);
    }
}