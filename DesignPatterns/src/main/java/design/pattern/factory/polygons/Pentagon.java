package design.pattern.factory.polygons;

public class Pentagon implements Polygon{

    int sides;
    String name;

    Pentagon() {
        this.sides = 5;
        this.name = this.getClass().getSimpleName();
    }

    @Override
    public int getSides() {
        return this.sides;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
