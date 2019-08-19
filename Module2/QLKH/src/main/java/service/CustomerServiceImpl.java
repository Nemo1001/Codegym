package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "duc", "phamhuyduc1094@gmail.com","HaNoi"));
        customers.put(2, new Customer(2,"tuan","lyanhtuan@gmail.com","HaNoi"));
    }

    @Override
    public List<Customer> findAll(){
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer){

        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findbyId(int id) {
        return customers.get(id);
    }


    @Override
    public  void update(int id, Customer customer){
        customers.put(id, customer);

    }

    @Override
    public void remove(int id){
        customers.remove(id);
    }
}