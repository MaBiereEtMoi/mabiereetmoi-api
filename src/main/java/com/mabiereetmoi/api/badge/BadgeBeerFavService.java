package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.favoriteBeer.FavoriteBeerService;
import com.mabiereetmoi.api.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class BadgeBeerFavService {
    private HashMap<Integer,String> badges_levels;

    private BadgeService badgeService;

    private FavoriteBeerService favoriteBeerService;

    @PostConstruct
    public void init(){
        badges_levels = new HashMap<>();
        badges_levels.put(1,"Mon premier flocon!");
        badges_levels.put(10,"Amateur de bon goût!");
        badges_levels.put(20,"Des étoiles pleins les verres!");
    }

    private int getNbBeerFav(String userId){
        return favoriteBeerService.getFavorites(userId).size();
    }

    public Badge check(String userId) throws UserNotFoundException {
        return badgeService.check(userId,badges_levels,getNbBeerFav(userId));
    }
}
