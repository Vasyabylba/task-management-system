package by.vasyabylba.taskmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.TaskStatus}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Task status request")
public class TaskStatusRequest {
    @Schema(description = "name", example = "in progress")
    @Size(min = 3, max = 255, message = "The name must contain between 3 and 255 characters")
    @NotBlank(message = "The name cannot be blank")
    private String name;
}