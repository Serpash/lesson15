package by.itacademy.lesson15.domain.goods;

public class Bread implements Good {
    @Override
    public String name() {
        return "Bread";
    }

    @Override
    public double price() {
        return 1.1;
    }

    @Override
    public String toString() {
        return name();
    }
}