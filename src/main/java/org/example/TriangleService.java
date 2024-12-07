package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriangleService {
    private final TriangleRepository triangleRepository;

    public TriangleService(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }
    public Triangle save(Triangle triangle) {
        return triangleRepository.save(triangle);
    }
    public List<Triangle> getAll() {
        return triangleRepository.findAll();
    }
}
