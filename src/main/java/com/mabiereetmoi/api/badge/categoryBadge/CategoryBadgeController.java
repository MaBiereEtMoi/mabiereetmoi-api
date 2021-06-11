package com.mabiereetmoi.api.badge.categoryBadge;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categoryBadge")
public class CategoryBadgeController {

    private final CategoryBadgeService categoryBadgeService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryBadge>> findAll() {
        return ResponseEntity.ok(categoryBadgeService.findAllCategory());
    }
}
