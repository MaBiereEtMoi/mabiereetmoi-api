package com.mabiereetmoi.api.badge.categoryBadge;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryBadgeService {

    private final CategoryBadgeRepository categoryBadgeRepository;

    public CategoryBadge findById(String name){
        return categoryBadgeRepository.findById(name).get();
    }

    public List<CategoryBadge> findAllCategory() {
        return categoryBadgeRepository.findAll();
    }

}
