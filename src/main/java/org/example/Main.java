package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0, 128);

        Shape triangle = new Triangle(3, 4, 5, color1);
        Shape rectangle = new Rectangle(4, 6, color2);

        System.out.println(triangle);
        System.out.println("Triangle Area: " + triangle.getArea());
        System.out.println("Triangle Perimeter: " + triangle.getPerimeter());

        System.out.println(rectangle);
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());

        ShapeDAO shapeDAO = new ShapeDAO();

        try {
            // Save shapes to the database
            shapeDAO.save(rectangle);
            shapeDAO.save(triangle);

            // Retrieve and describe all rectangles
            System.out.println("All Rectangles:");
            List<Rectangle> rectangles = shapeDAO.findAll(Rectangle.class);
            for (Rectangle rect : rectangles) {
                ShapeDescriber describer = new ShapeDescriber();
                describer.describe(rect);
            }

            // Retrieve and describe all triangles
            System.out.println("\nAll Triangles:");
            List<Triangle> triangles = shapeDAO.findAll(Triangle.class);
            for (Triangle tri : triangles) {
                ShapeDescriber describer = new ShapeDescriber();
                describer.describe(tri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the DAO
            shapeDAO.close();
        }
    }
}
