package cybersoft.javabackend.java18.gira.role.model;
import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name=RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {
    @Length(min=5, max=100, message="{Role.name.size}")
    @Column(name=RoleEntity.Role.NAME)
    private String name;

    @Column(name=RoleEntity.Role.CODE)
    @Length(min=3, max=10, message="Role code range must be between {min} and {max} characters")
    private String code;

    @Column(name=RoleEntity.Role.DESCRIPTION)
    @NotBlank(message = "Role description cannot be blank")
    private String description;

    @Override
    public boolean equals(Object obj){
        Role roleObj = (Role) obj;
        return super.equals(obj)
                && roleObj.name.equals(name)
                && roleObj.code.equals(code);
    }

}
