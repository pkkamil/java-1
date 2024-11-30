package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {
    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);

    public void describe(Shape shape) {
        logger.info("Describing shape: {}", shape.getClass().getSimpleName());
        logger.info("Color: {}", shape.getColorDescription());
        logger.info("Area: {}", shape.getArea());
        logger.info("Perimeter: {}", shape.getPerimeter());
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20, new Color(255, 200, 100));
        Shape triangle = new Triangle(5, 6, 7, new Color(0, 128, 255));

        ShapeDescriber describer = new ShapeDescriber();

        logger.info("Rectangle description:");
        describer.describe(rectangle);

        logger.info("\nTriangle description:");
        describer.describe(triangle);
    }
}
