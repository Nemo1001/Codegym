package com.codegym.service;

import com.codegym.model.Nation;

public interface NationService {
    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation nation);

    void remove(Long id);
}
