package com.codegym.repository;
import com.codegym.model.Receptionist;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ReceptionistRepository implements GeneralRepository<Receptionist> {
    private Map<Integer, Receptionist> receptionistList = new HashMap<>();


    @Override
    public List<Receptionist> findAll() {
        return new ArrayList<>(receptionistList.values());
    }

    @Override
    public void add(Receptionist receptionist) {
        receptionistList.put(receptionist.getId(),receptionist);
    }

    @Override
    public void upate(int id, Receptionist receptionist) {
        receptionistList.put(id, receptionist);
    }

    @Override
    public void delete(int id) {
        receptionistList.remove(id);
    }


    @Override
    public Receptionist findByName(String name) {
        List<Receptionist> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public Receptionist findById(int id) {
        return receptionistList.get(id);
    }
}


