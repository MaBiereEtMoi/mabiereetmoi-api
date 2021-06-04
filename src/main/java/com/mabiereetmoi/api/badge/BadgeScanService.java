package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.badge.categoryBadge.BadgeService;
import com.mabiereetmoi.api.badge.categoryBadge.CategoryBadgeService;
import com.mabiereetmoi.api.historisation.HistorisationService;
import com.mabiereetmoi.api.user.UserNotFoundException;
import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BadgeScanService extends BadgeService {

    private HashMap<Integer,String> scan_levels;

    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private HistorisationService historisationService;
    @Autowired
    private CategoryBadgeService categoryBadgeService;

    public BadgeScanService(UserService userService) {
        super(userService);
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

    @Override
    protected Badge check(String userId) throws UserNotFoundException {
        for(Integer key : scan_levels.keySet()){
            String name = scan_levels.get(key);
            if(!hasBadge(name,userId) && getNbScans(userId) >= key){
                return Badge.builder()
                        .name(name)
                        .category(categoryBadgeService.findById("SCAN"))
                        .build();
            }
        }
        return null;
    }
}
