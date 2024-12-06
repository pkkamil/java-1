import org.example.Color;
import org.example.Rectangle;
import org.example.ShapeDAO;
import org.example.Triangle;

import org.hibernate.Session;
import org.junit.jupiter.api.*;
import org.hibernate.SessionFactory;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeDAOTest {

    private static ShapeDAO shapeDAO;

    @BeforeEach
    void setUp() {
        shapeDAO = new ShapeDAO("hibernate-test.cfg.xml");
        try (Session session = shapeDAO.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Rectangle").executeUpdate();
            session.createQuery("DELETE FROM Triangle").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @AfterAll
    static void teardown() {
        shapeDAO.close();
    }

    @Test
    void testSaveAndFindRectangle() {
        // Tworzenie prostokąta
        Rectangle rectangle = new Rectangle(10.0, 5.0, new Color(255, 0, 0));
        shapeDAO.save(rectangle);

        // Odczytanie wszystkich prostokątów
        List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);

        assertEquals(1, rectangles.size());
        Rectangle retrieved = rectangles.get(0);
        assertEquals(10.0, retrieved.getWidth());
        assertEquals(5.0, retrieved.getHeight());
        assertEquals(new Color(255, 0, 0), retrieved.getColor());
    }

    @Test
    void testUpdateRectangle() {
        // Tworzenie i zapis prostokąta
        Rectangle rectangle = new Rectangle(8.0, 4.0, new Color(0, 255, 0));
        shapeDAO.save(rectangle);

        // Aktualizacja prostokąta
        List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);
        Rectangle toUpdate = rectangles.get(0);
        toUpdate.setWidth(12.0);
        shapeDAO.update(toUpdate);

        // Sprawdzenie aktualizacji
        rectangles = shapeDAO.findAll(Rectangle.class);
        assertEquals(12.0, rectangles.get(0).getWidth());
    }

    @Test
    void testDeleteRectangle() {
        // Tworzenie i zapis prostokąta
        Rectangle rectangle = new Rectangle(6.0, 3.0, new Color(0, 0, 255));
        shapeDAO.save(rectangle);

        // Usuwanie prostokąta
        List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);
        Rectangle toDelete = rectangles.get(0);
        shapeDAO.delete(toDelete);

        // Sprawdzenie, czy baza jest pusta
        rectangles = shapeDAO.findAll(Rectangle.class);
        assertTrue(rectangles.isEmpty());
    }

    @Test
    void testSaveAndFindTriangle() {
        // Tworzenie trójkąta
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, new Color(255, 255, 0));
        shapeDAO.save(triangle);

        // Odczytanie wszystkich trójkątów
        List<Triangle> triangles = shapeDAO.findAll(Triangle.class);

        assertEquals(1, triangles.size());
        Triangle retrieved = triangles.get(0);
        assertEquals(3.0, retrieved.getA());
        assertEquals(4.0, retrieved.getB());
        assertEquals(5.0, retrieved.getC());
        assertEquals(new Color(255, 255, 0), retrieved.getColor());
    }
}
