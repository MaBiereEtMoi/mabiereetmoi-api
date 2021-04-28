package com.mabiereetmoi.api.favoriteBeer;

import com.mabiereetmoi.api.beer.*;
import com.mabiereetmoi.api.security.SecurityService;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/favoriteBeer")
public class FavoriteBeerController {

    private final FavoriteBeerService favoriteBeerService;
    private final SecurityService securityService;
    private final BeerService beerService;
    private final BeerConverter beerConverter;

    @PostMapping("/addFavorite/{beerId}")
    public ResponseEntity<Beer> addFavorite(@PathVariable("beerId") Long beerId) throws BeerNotFoundException {
        User user = securityService.getUser();
        Beer beer = beerService.findById(beerId);
        FavoriteBeer favoriteBeer = FavoriteBeer.builder()
                .beer(beer)
                .user(user).build();
        return ResponseEntity.ok(favoriteBeerService.saveFavoriteBeer(favoriteBeer).getBeer());
    }

    @PostMapping("/removeFavorite/{beerId}")
    public ResponseEntity<Beer> removeFavorite(@PathVariable("beerId") Long beerId) {
        User user = securityService.getUser();
        FavoriteBeerId favoriteBeerId = new FavoriteBeerId();
        favoriteBeerId.setBeer(beerId);
        favoriteBeerId.setUser(user.getUid());
        favoriteBeerService.removeFavoriteBeer(favoriteBeerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("getFavorites")
    public ResponseEntity<List<BeerDto>> getFavorites() {
        User user = securityService.getUser();
        return ResponseEntity.ok(beerConverter.listEntityToDto(favoriteBeerService.getFavorites(user.getUid())));
    }
}
