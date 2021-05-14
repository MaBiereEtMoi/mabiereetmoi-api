package com.mabiereetmoi.api.rating;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {

    @Query(value = "SELECT avg(r.rating) FROM Rating r WHERE r.beer.idBeer = ?1")
    Double averageByBeer(Long beerId);

    List<Rating> findAllByBeerIdBeer(Long beerId);

}
