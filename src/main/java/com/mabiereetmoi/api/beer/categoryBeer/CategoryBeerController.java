package com.mabiereetmoi.api.beer.categoryBeer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categoryBeer")
public class CategoryBeerController {

    private final CategoryBeerService categoryBeerService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryBeer>> findAll() {
        return ResponseEntity.ok(categoryBeerService.findAllCategory());
    }

}
