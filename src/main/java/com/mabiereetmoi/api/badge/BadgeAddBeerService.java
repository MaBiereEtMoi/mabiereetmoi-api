package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class BadgeAddBeerService {
    private HashMap<Integer,String> badges_levels;

    private final BadgeService badgeService;

    @PostConstruct
    public void init(){
        badges_levels = new HashMap<>();
        badges_levels.put(1,"Pichard!");
        badges_levels.put(5,"Amateur!");
        badges_levels.put(10,"Connoisseur!");
    }

    private int getNbBeerAdded(String userId){
        return 0;
    }

    public Badge check(String userId) throws UserNotFoundException {
        return badgeService.check(userId,badges_levels,getNbBeerAdded(userId));
    }
}
