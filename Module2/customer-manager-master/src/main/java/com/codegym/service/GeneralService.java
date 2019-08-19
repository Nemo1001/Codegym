package com.codegym.service;
import com.codegym.model.Customer;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    void save(Customer customer);

    Customer findById(int id);

    void update(int id, T t);

    void remove(int id);
}
