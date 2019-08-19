package com.codegym.service;

import com.codegym.model.Receptionist;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(int id);
    void addElement(T element);
    List<T> findByName(String name);

    void delete(int id);

    void update(int id, Receptionist receptionist);
}
