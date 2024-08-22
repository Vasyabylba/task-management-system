package by.vasyabylba.taskmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Error response")
public class ErrorResponse {
    @Schema(description = "HTTP status", example = "BAD_REQUEST")
    private HttpStatus status;

    @Schema(description = "Error message", example = "User with email 'johndoe@gmail.com' already exists")
    private String message;

    @Schema(description = "Error time", example = "2024-01-01 00:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.time = LocalDateTime.now();
    }
}
