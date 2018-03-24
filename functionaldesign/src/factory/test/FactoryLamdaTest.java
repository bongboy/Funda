package factory.test;

import factory.FactoryLamda;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactoryLamdaTest {

    @Test
    void getShapeSquare() {
        Optional<FactoryLamda.Shape> shapeOptional = FactoryLamda.getShape("Square");
        /*System.out.println(shapeOptional
         .map(FactoryLamda.Shape::draw)
         .orElseThrow(IllegalArgumentException::new));*/
        assertEquals("Inside Square::draw() method.", (shapeOptional.
                orElseThrow(IllegalArgumentException::new))
                .draw());

    }

    @Test
    void getShapeCircle() {
        Optional<FactoryLamda.Shape> shapeOptional = FactoryLamda.getShape("Circle");
        //System.out.println(shapeOptional.map(Shape::draw).orElseThrow(IllegalArgumentException::new));
        assertEquals("Inside Circle::draw() method.", (shapeOptional
                .orElseThrow(IllegalArgumentException::new))
                .draw());

    }

    @Test
    void getShapeRectangle() {
        Optional<FactoryLamda.Shape> shapeOptional = FactoryLamda.getShape("Rectangle");
        //System.out.println(shapeOptional
        // .map(Shape::draw)
        // .orElseThrow(IllegalArgumentException::new));
        assertEquals("Inside Rectangle::draw() method.", (shapeOptional
                .orElseThrow(IllegalArgumentException::new))
                .draw());

    }

    @Test
    void getShapeSquareException() {
        Optional<FactoryLamda.Shape> shapeOptional = FactoryLamda.getShape("Triangle");
        //System.out.println(shapeOptional.map(Shape::draw).orElseThrow(IllegalArgumentException::new));
        assertThrows(IllegalArgumentException.class, () -> (shapeOptional
                .orElseThrow(IllegalArgumentException::new))
                .draw());

    }
}