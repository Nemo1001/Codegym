package com.codegym.service;

import com.codegym.model.Department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Iterable<Department> findAll();
    void save(Department department);
    void delete(Long id);
    Department findById(Long id);
}
