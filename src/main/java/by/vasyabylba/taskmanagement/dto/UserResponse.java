package by.vasyabylba.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.User}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User response")
public class UserResponse implements Serializable {
    @Schema(description = "ID", example = "1")
    private Long id;

    @Schema(description = "Email address", example = "johndoe@gmail.com")
    private String email;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Schema(description = "Date of create", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdAt;

    @Schema(description = "Date of update", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant updatedAt;
}
