package by.vasyabylba.taskmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 5, max = 255, message = "The email address must contain between 5 and 255 characters")
    @NotBlank(message = "The email address cannot be blank")
    @Email(message = "Email address must be in the format user@example.com")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min = 8, max = 255, message = "The password must contain between 8 and 255 characters")
    @NotBlank(message = "The password cannot be blank")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}