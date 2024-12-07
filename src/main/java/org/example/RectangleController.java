package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rectangles")
public class RectangleController {
    private final RectangleService rectangleService;

    public RectangleController(RectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }
    @GetMapping
    public List<Rectangle> getAll() {
        return rectangleService.getAll();
    }
    @PostMapping
    public Rectangle create(@RequestBody Rectangle rectangle) {
        return rectangleService.save(rectangle);
    }
}