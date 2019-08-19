package com.codegym.repository.impl;

import com.codegym.model.Receptionist;
import com.codegym.repository.ReceptionistRepository;

import java.util.List;

public class ReceptionistRepositoryImpl extends ReceptionistRepository {

    @Override
    public Receptionist findById(String name) {
        List<Receptionist> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }
    }

