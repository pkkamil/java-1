package org.example;

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
    }
}
