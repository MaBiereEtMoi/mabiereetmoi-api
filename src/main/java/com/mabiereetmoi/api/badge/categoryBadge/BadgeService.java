package com.mabiereetmoi.api.badge.categoryBadge;

import com.mabiereetmoi.api.badge.Badge;
import com.mabiereetmoi.api.user.UserNotFoundException;
import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public abstract class BadgeService {

    private UserService userService;

    protected abstract Badge check(String userId) throws UserNotFoundException;

    protected boolean hasBadge(String name, String userId) throws UserNotFoundException {
        List<Badge> badges = userService.findByUid(userId).getBadges();
        for(Badge badge : badges){
            if(badge.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
