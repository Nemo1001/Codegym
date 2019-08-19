package com.codegym.repository;

import com.codegym.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

    Page<Department> findAllByNameContaining(String name, Pageable pageable);
}
