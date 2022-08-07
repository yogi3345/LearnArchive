package learn.basic.generics.helper.beans;

public class Bike implements Vehicle{

    private final int profit;

    public Bike() {
        this.profit = (int) (Math.random() * 100d);
    }

    @Override
    public void run() {
        System.out.println("Bike running...");
    }

    @Override
    public int profit() {
        return profit;
    }
}
