package by.itacademy.lesson15;


import by.itacademy.lesson15.domain.Customer;

public interface CustomerQueue {
    void insert(Customer customer);
    Customer select();
}
