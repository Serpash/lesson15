package by.itacademy.lesson15.domain;

import by.itacademy.lesson15.CustomerQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedCustomerQueue implements CustomerQueue {
    private final Queue<Customer> customers = new LinkedList<>();
    Customer customer;

    @Override
    public synchronized void insert(Customer customer) {
        customers.add(customer);
        notify();
    }

    @Override
    public synchronized Customer select(){

        while (customers.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return customers.poll();


    }
}


