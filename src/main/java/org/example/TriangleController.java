package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/triangles")
public class TriangleController {
    private final TriangleService triangleService;

    public TriangleController(TriangleService triangleService) {
        this.triangleService = triangleService;
    }
    @GetMapping
    public List<Triangle> getAll() {
        return triangleService.getAll();
    }
    @PostMapping
    public Triangle create(@RequestBody Triangle triangle) {
        return triangleService.save(triangle);
    }
}