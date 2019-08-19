
package com.codegym.repository;

import com.codegym.cms.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}