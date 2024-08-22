package by.vasyabylba.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.TaskPriority}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Task priority response")
public class TaskPriorityResponse {
    @Schema(description = "ID", example = "1")
    Long id;

    @Schema(description = "name", example = "in progress")
    @Size(min = 3, max = 255, message = "The name must contain between 3 and 255 characters")
    @NotBlank(message = "The name cannot be blank")
    private String name;

    @Schema(description = "Date of create", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdAt;

    @Schema(description = "Date of update", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant updatedAt;
}