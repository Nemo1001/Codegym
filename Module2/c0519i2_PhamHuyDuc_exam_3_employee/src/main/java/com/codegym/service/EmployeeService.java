
package com.codegym.service;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll (Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Iterable<Employee> findAllByDepartment(Department department);
}