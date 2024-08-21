package by.vasyabylba.taskmanagement.dto;

import by.vasyabylba.taskmanagement.error.Violation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Validation error response")
public class ValidationErrorResponse {
    @Schema(description = "Error list", example = """
            [
                {
                  "fieldName": "email",
                  "message": "Email address must be in the format user@example.com"
                }
            ]""")
    @JsonProperty("errors")
    private List<Violation> violations;
}
