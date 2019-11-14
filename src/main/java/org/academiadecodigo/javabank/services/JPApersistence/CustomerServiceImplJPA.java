package org.academiadecodigo.javabank.services.JPApersistence;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.List;
import java.util.Set;

public class CustomerServiceImplJPA implements CustomerService {


    @Override
    public Customer get(Integer id) {
        return null;
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return null;
    }

    @Override
    public double getBalance(int id) {
        return 0;
    }

    @Override
    public void add(Customer customer) {

    }
}
