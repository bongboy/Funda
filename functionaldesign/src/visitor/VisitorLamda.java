package visitor;

import java.util.Arrays;
import java.util.List;

public class VisitorLamda {

    public static void main(String[] args) {

        List<Element> figures = Arrays.asList(new Circle(5), new Square(5),
                new Rectangle(5, 7));

        Visitor<Double> area = (element -> {
            if (Square.class.isInstance(element)) {
                Square square = (Square) element;
                return square.sides * square.sides;
            } else if (Circle.class.isInstance(element)) {
                Circle circle = (Circle) element;
                return Math.PI * circle.radius * circle.radius;
            } else if (Rectangle.class.isInstance(element)) {
                Rectangle rectangle = (Rectangle) element;
                return rectangle.width * rectangle.height;
            } else
                throw new IllegalArgumentException();
        });

        Visitor<Double> perimeter = (element -> {
            if (Square.class.isInstance(element)) {
                Square square = (Square) element;
                return 4 * square.sides;
            } else if (Circle.class.isInstance(element)) {
                Circle circle = (Circle) element;
                return Math.PI * 2 * circle.radius;
            } else if (Rectangle.class.isInstance(element)) {
                Rectangle rectangle = (Rectangle) element;
                return 2 * (rectangle.width + rectangle.height);
            } else
                throw new IllegalArgumentException();
        });

        Double totalArea = 0.0;
        Double totalPerimeter = 0.0;

        for (Element figure : figures) {
            totalArea += figure.accept(area);
        }

        for (Element figure : figures) {
            totalPerimeter += figure.accept(perimeter);
        }

        System.out.println("Area: " + totalArea + "\nPerimeter: " + totalPerimeter);

    }

    public interface Element {
        <T> T accept(Visitor<T> visitor);
    }

    public interface Visitor<T> {
        T visit(Element element);
    }

    public static class Square implements Element {

        private double sides;

        public Square(double sides) {
            this.sides = sides;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class Circle implements Element {

        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class Rectangle implements Element {

        private double height;
        private double width;

        public Rectangle(double height, double width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }
}
