package org.example;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Shape {
    @Embedded
    private Color color;

    public Shape() {}

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getColorDescription() {
        return "Red: " + color.getRed() + ", Green: " + color.getGreen() + ", Blue: " + color.getBlue() + ", Alpha: " + color.getAlpha();
    }

    public Color getColor() {
        return color;
    }
}
