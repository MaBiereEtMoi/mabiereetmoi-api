package com.mabiereetmoi.api.favoriteBeer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteBeerRepository extends CrudRepository<FavoriteBeer, FavoriteBeerId> {

    List<FavoriteBeer> findAllByUserUid(String uid);

    Integer countAllByBeer_IdBeer(Long beerId);

}
