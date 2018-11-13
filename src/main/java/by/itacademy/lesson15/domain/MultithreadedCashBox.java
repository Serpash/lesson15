package by.itacademy.lesson15.domain;

import by.itacademy.lesson15.CustomerQueue;

import java.util.Queue;

public class MultithreadedCashBox {
    private CashBox cashBox;

    public MultithreadedCashBox(CustomerQueue queue) {
        this.cashBox = new CashBox(queue);
    }

    public void service() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    cashBox.service();
                }
            }
        });
        thread.start();
    }
}