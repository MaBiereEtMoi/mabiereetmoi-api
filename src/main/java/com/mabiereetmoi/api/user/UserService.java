package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.badge.Badge;
import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.researchUser.SearchCriteria;
import com.mabiereetmoi.api.researchUser.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUid(String uid) throws UserNotFoundException {
        return userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));
    }

    public List<User> searchByUsername(String search){
        UserSpecification spec =
                new UserSpecification(new SearchCriteria("username", ":", search));
        return userRepository.findAll(Specification.where(spec));
    }

    public boolean hasBadge(String name, String userId) throws UserNotFoundException {
        List<Badge> badges = findByUid(userId).getBadges();
        for(Badge badge : badges){
            if(badge.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

}
