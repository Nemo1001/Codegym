package com.codegym.cms.repository;

import java.util.List;

public interface CustomerRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
