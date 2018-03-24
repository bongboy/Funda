package visitor;

import java.util.Arrays;
import java.util.List;

public class VisitorGOF {

    public static void main(String[] args) {

        List<Element> figures = Arrays.asList(new Circle(5), new Square(5), new Rectangle(5, 7));

        AreaVisitor area = new AreaVisitor();
        PerimeterVisitor perimeter = new PerimeterVisitor();

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
        T visit(Square square);

        T visit(Circle circle);

        T visit(Rectangle rectangle);
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

    public static class AreaVisitor implements Visitor<Double> {

        @Override
        public Double visit(Square square) {
            return square.sides * square.sides;
        }

        @Override
        public Double visit(Circle circle) {
            return Math.PI * circle.radius * circle.radius;
        }

        @Override
        public Double visit(Rectangle rectangle) {
            return rectangle.width * rectangle.height;
        }
    }

    public static class PerimeterVisitor implements Visitor<Double> {

        @Override
        public Double visit(Square square) {
            return 4 * square.sides;
        }

        @Override
        public Double visit(Circle circle) {
            return Math.PI * 2 * circle.radius;
        }

        @Override
        public Double visit(Rectangle rectangle) {
            return 2 * (rectangle.width + rectangle.height);
        }
    }
}
