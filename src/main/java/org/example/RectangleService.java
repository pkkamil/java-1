package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectangleService {
    private final RectangleRepository rectangleRepository;

    public RectangleService(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
    }
    public Rectangle save(Rectangle rectangle) {
        return rectangleRepository.save(rectangle);
    }
    public List<Rectangle> getAll() {
        return rectangleRepository.findAll();
    }
}
