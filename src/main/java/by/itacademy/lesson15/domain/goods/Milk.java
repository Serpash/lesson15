package by.itacademy.lesson15.domain.goods;

public class Milk implements Good {
    @Override
    public String name() {
        return "Milk";
    }

    @Override
    public double price() {
        return 2.5;
    }

    @Override
    public String toString() {
        return name();
    }
}