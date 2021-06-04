package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.comment.CommentService;
import com.mabiereetmoi.api.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class BadgeCommentService {
    private HashMap<Integer,String> badges_levels;

    private CommentService commentService;

    private BadgeService badgeService;

    @PostConstruct
    public void init(){
        badges_levels = new HashMap<>();
        badges_levels.put(1,"Il faut vaincre sa timidité!");
        badges_levels.put(10,"C'est bien, tu t'affirmes!");
        badges_levels.put(20,"Débat présidentiel!");
        badges_levels.put(50,"Doit surveiller ses bavardages au second trimestre!");
        badges_levels.put(100,"Sacré pipelette!");
    }

    private int getNbComment(String userId){
        return commentService.getNbComment(userId);
    }

    public Badge check(String userId) throws UserNotFoundException {
        return badgeService.check(userId,badges_levels,getNbComment(userId));
    }
}
