package org.example;

public class Triangle extends Shape {
    private final double a, b, c;

    public Triangle(double a, double b, double c, Color color) {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Podane boki nie tworzą trójkąta!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle[a=" + a + ", b=" + b + ", c=" + c + ", color=" + getColorDescription() + "]";
    }
}
