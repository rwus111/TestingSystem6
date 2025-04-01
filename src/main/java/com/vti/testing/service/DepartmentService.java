package com.vti.testing.service;

import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentCreatingForm;
import com.vti.testing.form.DepartmentFilterForm;
import com.vti.testing.repository.IAccountRepository;
import com.vti.testing.repository.IDepartmentRepository;
import com.vti.testing.specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Department> getAll(DepartmentFilterForm form) {
        Specification<Department> where = DepartmentSpecification.buildWhere(form);
        return departmentRepository.findAll(where);
    }

    @Override
    public void createDepartment(DepartmentCreatingForm form) {
        Department department = modelMapper.map(form, Department.class);
        departmentRepository.save(department);
        List<Account> accounts = department.getAccounts();
        for (Account account : accounts) {
            account.setDepartment(department);
        }
        accountRepository.saveAll(accounts);
    }
}
