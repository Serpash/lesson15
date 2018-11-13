package by.itacademy.lesson15.domain.goods;

public class Chicken implements Good {
    @Override
    public String name() {
        return "Chicken";
    }

    @Override
    public double price() {
        return 7.32;
    }

    @Override
    public String toString() {
        return name();
    }
}