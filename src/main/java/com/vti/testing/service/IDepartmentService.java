package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentCreatingForm;
import com.vti.testing.form.DepartmentFilterForm;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAll(DepartmentFilterForm form);

    void createDepartment(DepartmentCreatingForm form);
}
