package com.codegym.service;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee findById(Long id);
    void save(Employee employee);
    void delete(Long id);
    Page<Employee> findAll(Pageable pageable);
    Iterable<Employee> findAllByDepartment(Department department);

}
