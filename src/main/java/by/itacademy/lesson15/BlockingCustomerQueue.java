package by.itacademy.lesson15;

import by.itacademy.lesson15.domain.Customer;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class BlockingCustomerQueue implements CustomerQueue {
    private final BlockingQueue<Customer> customers = new LinkedBlockingDeque<>();
    @Override
    public  void insert(Customer customer) {
        try {
            customers.put(customer);
        } catch (InterruptedException e) {
            throw new IllegalThreadStateException(e.getMessage());
        }

    }

    @Override
    public  Customer select() {
        try {
            return customers.take();
        } catch (InterruptedException e) {
            throw new IllegalThreadStateException(e.getMessage());
        }
    }
}
