package com.mabiereetmoi.api.favoriteBeer;

import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavoriteBeerService {

    private final FavoriteBeerRepository favoriteBeerRepository;

    public FavoriteBeer saveFavoriteBeer(FavoriteBeer favoriteBeer) {
        return favoriteBeerRepository.save(favoriteBeer);
    }

    public void removeFavoriteBeer(FavoriteBeerId favoriteBeerId) {
        favoriteBeerRepository.deleteById(favoriteBeerId);
    }

    public boolean isFavorite(FavoriteBeerId favoriteBeerId) {
        return favoriteBeerRepository.existsById(favoriteBeerId);
    }

    public List<Beer> getFavorites(String uid) {
        return favoriteBeerRepository.findAllByUserUid(uid).stream().map(FavoriteBeer::getBeer).collect(Collectors.toList());
    }

}
