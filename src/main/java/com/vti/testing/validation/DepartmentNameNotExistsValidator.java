package com.vti.testing.validation;

import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists, String> {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !departmentRepository.existsByName(name);
    }
}
