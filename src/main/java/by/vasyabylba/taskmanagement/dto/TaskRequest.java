package by.vasyabylba.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.Task}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Task request")
public class TaskRequest implements Serializable {
    @Schema(description = "title", example = "Create a task")
    @Size(min = 3, max = 255, message = "The title must contain between 3 and 255 characters")
    @NotBlank(message = "The title cannot be blank")
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
}