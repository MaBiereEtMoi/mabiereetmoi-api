package com.mabiereetmoi.api.beer.categoryBeer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryBeerRepository extends CrudRepository<CategoryBeer, Long> {

    List<CategoryBeer> findAll();

}
