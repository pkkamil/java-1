import org.example.Color;
import org.example.Rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testGetArea() {
        Rectangle rectangle = new Rectangle(10, 20, new Color(255, 0, 0));
        assertEquals(200, rectangle.getArea());
    }

    @Test
    void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(10, 20, new Color(255, 0, 0));
        assertEquals(60, rectangle.getPerimeter());
    }

    @Test
    void testGetColorDescription() {
        Rectangle rectangle = new Rectangle(10, 20, new Color(255, 0, 0, 128));
        assertEquals("Red: 255, Green: 0, Blue: 0, Alpha: 128", rectangle.getColorDescription());
    }
}
