package com.mabiereetmoi.api.beer.requestBeer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestBeerRepository extends CrudRepository<RequestBeer, Long> {

    Integer countAllByPending(Boolean pending);

    List<RequestBeer> findAll();

}
