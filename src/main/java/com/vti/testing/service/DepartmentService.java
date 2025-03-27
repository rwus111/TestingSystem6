package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentFilterForm;
import com.vti.testing.repository.IDepartmentRepository;
import com.vti.testing.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll(DepartmentFilterForm form) {
        Specification<Department> where = DepartmentSpecification.buildWhere(form);
        return departmentRepository.findAll(where);
    }
}
