package com.mabiereetmoi.api.beer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer,Long> {
    List<Beer> findAll();
}
