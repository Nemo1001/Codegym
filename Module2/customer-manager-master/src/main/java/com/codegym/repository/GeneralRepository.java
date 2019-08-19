package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.List;

public interface GeneralRepository <T> {
    List<T> findAll();
    void save(T t);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
