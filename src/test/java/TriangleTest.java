import org.example.Color;
import org.example.Triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testGetArea() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(0, 255, 0));
        assertEquals(6, triangle.getArea(), 0.0001);
    }

    @Test
    void testGetPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(0, 255, 0));
        assertEquals(12, triangle.getPerimeter());
    }

    @Test
    void testGetColorDescription() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(0, 255, 0, 128));
        assertEquals("Red: 0, Green: 255, Blue: 0, Alpha: 128", triangle.getColorDescription());
    }
}
