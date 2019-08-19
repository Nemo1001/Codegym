package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements GeneralRepository <Customer>{
    private static   Map<Integer, Customer> customers;

     static { customers = new HashMap<>();
        customers.put(1, new Customer(1, "Ibrahimovic", "ibrahimovic@gmail.com", "LA galaxy"));
        customers.put(2, new Customer(2, "Cristian Ronaldo", "CristianRonaldo@gmail.com", "Juventus"));
        customers.put(3, new Customer(3, "mesut Osil", "mesutOsil@gmail.com", "Arsenal"));
        customers.put(4, new Customer(4, "Leo Messi", "messi@gmail.com", "Barcelona"));
        customers.put(5, new Customer(5, "Delight", "Delight@gmail.com", "Juventus"));
        customers.put(6, new Customer(6, "Lampard", "Lampard@gmail.com", "Chelsea"));
        customers.put(7, new Customer(7, "Torres", "Torres@gmail.com", "Liverpool"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id){
        return customers.get(id);
    }

    @Override
    public  void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id){
        customers.remove(id);
    }
}
