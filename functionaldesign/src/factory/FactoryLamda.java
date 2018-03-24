package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FactoryLamda {

    private static Map<String, Shape> shapeMap = new HashMap<>();

    static {
        shapeMap.put("Circle", new Circle());
        shapeMap.put("Square", new Square());
        shapeMap.put("Rectangle", new Rectangle());

    }

    public static Optional<Shape> getShape(String getShape) {
        return Optional.ofNullable(shapeMap.get(getShape));
    }

    public interface Shape {
        String draw();
    }

    private static class Rectangle implements Shape {
        @Override
        public String draw() {
            return "Inside Rectangle::draw() method.";
        }
    }

    private static class Circle implements Shape {
        @Override
        public String draw() {
            return "Inside Circle::draw() method.";
        }
    }

    private static class Square implements Shape {
        @Override
        public String draw() {
            return "Inside Square::draw() method.";
        }
    }
}
