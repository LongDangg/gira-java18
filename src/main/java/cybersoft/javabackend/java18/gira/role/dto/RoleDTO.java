package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private UUID id;

    @Length(min=5, max=100, message="Role name range must be between {min} and {max} characters")
    @NotBlank(message = "Role name cannot be blank")
    @UniqueRoleName
    private String name;

    @Length(min=3, max=10, message="{role.code.size}")
    @NotBlank(message = "Role code cannot be blank")
    private String code;

    @NotBlank(message = "{role.description.blank}")
    private String description;
}
