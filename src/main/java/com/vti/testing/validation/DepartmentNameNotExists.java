package com.vti.testing.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DepartmentNameNotExistsValidator.class})
public @interface DepartmentNameNotExists {
    String message() default "Department name exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
