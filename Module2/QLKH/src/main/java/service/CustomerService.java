package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    void save(Customer customer);

    Customer findbyId(int id);

    void update(int id, Customer customer);

    void remove(int id);

}
