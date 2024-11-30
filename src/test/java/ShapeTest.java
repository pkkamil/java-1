import org.example.Color;
import org.example.Rectangle;
import org.example.Shape;
import org.example.Triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testRectangleInheritance() {
        Shape rectangle = new Rectangle(10, 20, new Color(255, 0, 0));
        assertEquals(200, rectangle.getArea());
        assertEquals(60, rectangle.getPerimeter());
        assertEquals("Red: 255, Green: 0, Blue: 0, Alpha: 0", rectangle.getColorDescription());
    }

    @Test
    void testTriangleInheritance() {
        Shape triangle = new Triangle(3, 4, 5, new Color(0, 255, 0));
        assertEquals(6, triangle.getArea(), 0.0001);
        assertEquals(12, triangle.getPerimeter());
        assertEquals("Red: 0, Green: 255, Blue: 0, Alpha: 0", triangle.getColorDescription());
    }
}
