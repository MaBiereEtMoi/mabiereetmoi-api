package com.mabiereetmoi.api.badge.categoryBadge;

import com.mabiereetmoi.api.badge.Badge;
import com.mabiereetmoi.api.badge.BadgeRepository;
import com.mabiereetmoi.api.user.User;
import com.mabiereetmoi.api.user.UserNotFoundException;
import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public abstract class BadgeService {

    private BadgeRepository badgeRepository;

    private UserService userService;

    public Badge getBadgeByName(String name){
        return badgeRepository.findByNameEquals(name);
    }

    public Badge check(String userId, HashMap<Integer,String> badges_levels, int nb) throws UserNotFoundException {
        for(Integer key : badges_levels.keySet()){
            String name = badges_levels.get(key);
            if(!userService.hasBadge(name,userId) && nb >= key){
                Badge badge = getBadgeByName(name);
                User user = userService.findByUid(userId);
                user.getBadges().add(badge);
                userService.saveUser(user);
                return badge;
            }
        }
        return null;
    }
}
