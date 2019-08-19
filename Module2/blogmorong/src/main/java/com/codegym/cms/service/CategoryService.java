package com.codegym.cms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Locale;

public interface  CategoryService {
    Page<Locale.Category> findAll(Pageable pageable);
    static Locale.Category findById(long id);
    void save (Locale.Category category);
    void remove(Long id);
    Page<Locale.Category> findAllByNameContaining(String name, Pageable pageable);


}
