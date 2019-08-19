package com.codegym.service.impl;

import com.codegym.model.Receptionist;
import com.codegym.repository.ReceptionistRepository;
import com.codegym.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReceptionistServiceImpl implements ReceptionistService {
    @Autowired
   private ReceptionistRepository receptionistRepository;

    @Override
    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();
    }

    @Override
    public Receptionist findById(int id)
    {
        return receptionistRepository.findById(id);
    }

    @Override
    public void addElement(Receptionist element) {

    }

    @Override
    public List<Receptionist> findByName(String name) {
        return (List<Receptionist>) receptionistRepository.findByName(name);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Receptionist receptionist) {

    }

    @Override
    public void add(Receptionist receptionist) {

    }
}
