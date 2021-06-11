package com.mabiereetmoi.api.badge.categoryBadge;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryBadgeRepository extends CrudRepository<CategoryBadge, String> {

    List<CategoryBadge> findAll();

}
