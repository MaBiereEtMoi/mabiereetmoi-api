package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userSecurity = securityService.getUser();
        if (user.getUid().equals(userSecurity.getUid())) {
            return ResponseEntity.ok(userService.saveUser(user));
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<User> me() throws UserNotFoundException {
        User userSecurity = securityService.getUser();
        User user = userService.findByUid(userSecurity.getUid());
        return ResponseEntity.ok(user);
    }

}
