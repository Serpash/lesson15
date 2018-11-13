package by.itacademy.lesson15.domain;

import by.itacademy.lesson15.CustomerQueue;
import by.itacademy.lesson15.domain.goods.Good;

import java.util.List;
import java.util.Queue;

import static java.lang.Thread.currentThread;

public class CashBox {
    private final CustomerQueue queue;
    Customer customer;

    public CashBox(CustomerQueue queue) {
        this.queue = queue;
    }

    public void service() {
        Customer customer = queue.select();
        StringBuilder s = new StringBuilder();
        if (customer.buy(costOf(customer.goods()))) {
            s.append(customer.goods());
        } else {
            s.append("Недостаточно средств!");
        }
        s.append(" ").append(customer.name())
                .append(" ").append(customer.cash())
                .append(" ").append(currentThread().getName());
        System.out.println(s);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double costOf(List<Good> goods) {
        double cost = 0;
        for (Good g : goods) {
            cost += g.price();
        }
        return cost;
    }
}