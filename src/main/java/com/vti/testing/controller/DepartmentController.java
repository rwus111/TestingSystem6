package com.vti.testing.controller;

import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentFilterForm;
import com.vti.testing.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<DepartmentDTO> getAll(DepartmentFilterForm form) {
        List<Department> departments = departmentService.getAll(form);
        return modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>() {
        }.getType());
    }
}
