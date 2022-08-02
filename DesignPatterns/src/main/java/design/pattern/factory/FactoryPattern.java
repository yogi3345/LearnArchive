package design.pattern.factory;

import design.pattern.factory.polygons.PolygonFactory;
import design.pattern.factory.polygons.Polygon;
import design.pattern.factory.polygons.PolygonType;
import design.pattern.factory.polygons.Triangle;

public class FactoryPattern {
    public static void main(String args[]) {
        Polygon polygon = PolygonFactory.getPolygon(PolygonType.TRIANGLE);
        System.out.println(polygon.getName());
        System.out.println(polygon.getSides());

        System.out.println("--------------------------------" + "\n");

        Polygon polygon2 = PolygonFactory.getPolygon(PolygonType.SQUARE);
        System.out.println(polygon2.getName());
        System.out.println(polygon2.getSides());

        System.out.println("--------------------------------" + "\n");

        Polygon polygon3 = PolygonFactory.getPolygon(PolygonType.PENTAGON);
        System.out.println(polygon3.getName());
        System.out.println(polygon3.getSides());
    }
}
