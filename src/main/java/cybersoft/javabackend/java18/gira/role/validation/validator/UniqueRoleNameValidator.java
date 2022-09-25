package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.annotation.UniqueRoleName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {

    private String message;
    private RoleRepository repository;

    public UniqueRoleNameValidator(RoleRepository repository){
        this.repository=repository;
    }
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Role> roleOptional = repository.findByName(name);
        if(roleOptional.isEmpty()){
            return true;
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }

    @Override
    public void initialize(UniqueRoleName constraintAnnotation){
        message = constraintAnnotation.message();
    }
}
