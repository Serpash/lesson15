package by.itacademy.lesson15.domain;

import by.itacademy.lesson15.CustomerQueue;
import by.itacademy.lesson15.domain.goods.Bread;
import by.itacademy.lesson15.domain.goods.Chicken;
import by.itacademy.lesson15.domain.goods.Milk;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CustomerGenerator {
    private final CustomerQueue queue;
    private List<Customer> regularCustomers = Arrays.asList(
            new Customer(39, "Lena").add(new Milk()).add(new Bread()),
            new Customer(9, "Sergei").add(new Milk()).add(new Chicken()),
            new Customer(1332, "Nikita").add(new Bread()).add(new Milk()).add(new Chicken()),
            new Customer(34, "Danila").add(new Milk()).add(new Chicken()),
            new Customer(54, "Dmitri").add(new Milk()).add(new Chicken()),
            new Customer(11, "Yan").add(new Milk()).add(new Chicken()),
            new Customer(578, "Irina").add(new Milk()).add(new Chicken()));
    private final Random random = new Random();

    public CustomerGenerator(CustomerQueue queue) {
        this.queue = queue;
    }

    public void execute() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Customer customer = regularCustomers.get(random.nextInt(7));

                    queue.insert(customer);
                }
            }
        });
        thread.start();

    }
}