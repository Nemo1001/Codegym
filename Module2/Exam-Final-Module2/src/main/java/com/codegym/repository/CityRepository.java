package com.codegym.repository;

import com.codegym.model.City;
import com.codegym.model.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Iterable<City> findAllByNation(Nation nation);
    Page<City> findAllByNameContaining(String Name, Pageable pageable);
}
