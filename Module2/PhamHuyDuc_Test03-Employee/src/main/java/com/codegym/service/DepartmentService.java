package com.codegym.service;

import com.codegym.model.Department;

public interface DepartmentService {
    Iterable<Department> findAll();
    void save(Department department);
    void delete(Long id);
    Department findById(Long id);
}
