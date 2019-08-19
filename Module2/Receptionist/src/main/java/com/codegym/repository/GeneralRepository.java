package com.codegym.repository;

import com.codegym.model.Receptionist;

import java.util.List;

public interface GeneralRepository<T> {
    List<T> findAll();
    void add(T t);
    void upate(int id, T t);
    void delete(int id);
    T findById(String name);

    Receptionist findByName(String name);

    T findById(int id);
}
