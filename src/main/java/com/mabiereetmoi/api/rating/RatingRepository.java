package com.mabiereetmoi.api.rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, RatingId> {
}
