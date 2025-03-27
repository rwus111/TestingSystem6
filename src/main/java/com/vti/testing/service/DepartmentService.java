package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
