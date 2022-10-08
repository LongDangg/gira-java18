package cybersoft.javabackend.java18.gira.user.dto;

import cybersoft.javabackend.java18.gira.user.model.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link cybersoft.javabackend.java18.gira.user.model.User} entity
 */
@Data
@Builder
public class UserDTO implements Serializable {
    private final UUID id;
    private final String username;
    private final String password;
    private final String email;
    private final String displayName;
    private final String fullname;
    private final String avatar;
    private final User.Status status;
}
