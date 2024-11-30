package org.example;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getColorDescription() {
        return "Red: " + color.red() + ", Green: " + color.green() + ", Blue: " + color.blue() + ", Alpha: " + color.alpha();
    }

    public Color getColor() {
        return color;
    }
}
