package design.pattern.factory.polygons;

public class Square implements Polygon{

    int sides;
    String name;

    Square() {
        this.sides = 4;
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
