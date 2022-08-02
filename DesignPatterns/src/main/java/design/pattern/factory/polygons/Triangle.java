package design.pattern.factory.polygons;

public class Triangle implements Polygon{

    int sides;
    String name;

    Triangle() {
        this.sides = 3;
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
