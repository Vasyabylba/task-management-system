package by.vasyabylba.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.Task}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Task response")
public class TaskResponse implements Serializable {
    @Schema(description = "ID", example = "1")
    Long id;

    @Schema(description = "title", example = "Create a task")
    String title;

    @Schema(description = "Description", example = "You need to create a new task")
    String description;

    @Schema(description = "Status", example = "Pending")
    String status;

    @Schema(description = "Priority", example = "High")
    String priority;

    @Schema(description = "Author ID", example = "1")
    @JsonProperty("author_id")
    Long authorId;

    @Schema(description = "Assignee ID", example = "2")
    @JsonProperty("assignee_id")
    Long assigneeId;

    @Schema(description = "Date of create", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdAt;

    @Schema(description = "Date of update", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant updatedAt;
}