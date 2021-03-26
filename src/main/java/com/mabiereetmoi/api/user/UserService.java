package com.mabiereetmoi.api.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUid(String uid) throws UserNotFoundException {
        return userRepository.findById(uid).orElseThrow(() -> new UserNotFoundException(uid));
    }

}
