package com.mabiereetmoi.api.beer.categoryBeer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryBeerService {

    private final CategoryBeerRepository categoryBeerRepository;

    public List<CategoryBeer> findAllCategory() {
        return categoryBeerRepository.findAll();
    }

}
