package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "rectangles")
public class Rectangle extends Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private double height;

    public Rectangle(double width, double height, Color color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero!");
        }
        this.width = width;
        this.height = height;
    }

    public Rectangle() {}

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
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

    private String colorToString(Color color) {
        return color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha();
    }

    private Color stringToColor(String colorString) {
        String[] parts = colorString.split(",");
        return new Color(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3])
        );
    }
}
