package cybersoft.javabackend.java18.gira.role.validation.annotation;

import cybersoft.javabackend.java18.gira.role.validation.validator.UniqueRoleNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueRoleNameValidator.class)
@Target(ElementType.FIELD) // Define target (class/method/field) which this annotation will be used for (here is field)
@Retention(RetentionPolicy.RUNTIME) // Define WHEN this annotation will be applied (run time, source...)
public @interface UniqueRoleName {
    // Annotation is added into RoleDTO to make sure the role's name is unique
    String message() default "{role.name.existed}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
