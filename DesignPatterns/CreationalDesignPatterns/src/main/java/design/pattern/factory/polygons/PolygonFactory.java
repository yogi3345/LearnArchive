package design.pattern.factory.polygons;

public class PolygonFactory {

    public static Polygon getPolygon(PolygonType polygonType) {
        if (polygonType.equals(PolygonType.TRIANGLE)) {
            return new Triangle();
        }
        if (polygonType.equals(PolygonType.SQUARE)) {
            return new Square();
        }
        if (polygonType.equals(PolygonType.PENTAGON)) {
            return new Pentagon();
        }
        return null;
    }
}
