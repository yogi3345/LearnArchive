package learn.basic.generics.helper.beans;

public class Car implements Vehicle{

    private final int profit;

    public Car() {
        this.profit = (int) (Math.random() * 1000d);
    }

    @Override
    public void run() {
        System.out.println("Car running...");
    }

    @Override
    public int profit() {
        return profit;
    }
}
