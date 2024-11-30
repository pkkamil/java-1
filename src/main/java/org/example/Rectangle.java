package org.example;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height, Color color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Szerokość i wysokość muszą być większe od zera!");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + ", color=" + getColorDescription() + "]";
    }
}
