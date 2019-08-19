package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    void save(City city);

    void remove(Long id);

    Iterable<City> findAllByNation(Nation nation);

    Page<City>  findAllByNameContaining(String name, Pageable pageable);
}
