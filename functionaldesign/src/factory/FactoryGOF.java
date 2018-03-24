package factory;

public class FactoryGOF {

    public static Shape getShape(String getShape) {
        switch (getShape) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("No such shape");
        }
    }

    public static void main(String[] args) {
        Shape shape = FactoryGOF.getShape("Triangle");
        shape.draw();
    }

    public interface Shape {
        void draw();
    }

    private static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    private static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }

    private static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }
}
