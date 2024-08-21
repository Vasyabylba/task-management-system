package by.vasyabylba.taskmanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link by.vasyabylba.taskmanagement.model.User}
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User request")
public class UserRequest implements Serializable {
    @Schema(description = "Email address", example = "johndoe@gmail.com")
    @Size(min = 5, max = 255, message = "The email address must contain between 5 and 255 characters")
    @NotBlank(message = "The email address cannot be blank")
    @Email(message = "Email address must be in the format user@example.com")
    private String email;

    @Schema(description = "Password", example = "my1_secret2_pass3word")
    @Size(min = 8, max = 255, message = "The password must contain between 8 and 255 characters")
    @NotBlank(message = "The password cannot be blank")
    private String password;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;
}