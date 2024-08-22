package by.vasyabylba.taskmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.Comment}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Comment request")
public class CommentRequest {
    @Schema(description = "content", example = "example")
    @NotBlank(message = "The content cannot be blank")
    private String content;

    @Schema(description = "Author ID", example = "1")
    private Long authorId;
}