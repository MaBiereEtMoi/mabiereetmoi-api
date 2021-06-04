package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.badge.categoryBadge.BadgeService;
import com.mabiereetmoi.api.historisation.HistorisationService;
import com.mabiereetmoi.api.user.User;
import com.mabiereetmoi.api.user.UserNotFoundException;
import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class BadgeScanService {

    private HashMap<Integer,String> scan_levels;

    private UserService userService;

    private HistorisationService historisationService;

    private BadgeService badgeService;

    @PostConstruct
    public void init(){
        scan_levels = new HashMap<>();
        scan_levels.put(1,"Il y un a début à tout!");
        scan_levels.put(10,"Pas mal pour un débutant!");
        scan_levels.put(20,"Serious business!");
        scan_levels.put(50,"Ah ouais, ça rigole plus!");
        scan_levels.put(100,"Started from the bottom, now we beer!");
    }

    private int getNbScans(String userId){
        return historisationService.getHistorisationByUser(userId).size();
    }

    protected Badge check(String userId) throws UserNotFoundException {
        return badgeService.check(userId,scan_levels,getNbScans(userId));
    }
}
