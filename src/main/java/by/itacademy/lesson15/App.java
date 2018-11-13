package by.itacademy.lesson15;

import by.itacademy.lesson15.domain.Customer;
import by.itacademy.lesson15.domain.CustomerGenerator;
import by.itacademy.lesson15.domain.MultithreadedCashBox;
import by.itacademy.lesson15.domain.SynchronizedCustomerQueue;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
       CustomerQueue queue = new BlockingCustomerQueue();
        new MultithreadedCashBox(queue).service();
        new MultithreadedCashBox(queue).service();
        new CustomerGenerator(queue).execute();
    }
}