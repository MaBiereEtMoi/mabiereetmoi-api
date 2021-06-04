package com.mabiereetmoi.api.user;
import com.mabiereetmoi.api.security.SecurityService;
import com.mabiereetmoi.api.storage.FileDto;
import com.mabiereetmoi.api.storage.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserDetailConverter userDetailConverter;
    private final StorageService storageService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userSecurity = securityService.getUser();
        if (user.getUid().equals(userSecurity.getUid())) {
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/pictureProfil")
    public ResponseEntity<UserDetailDto> changePictureProfil(@RequestParam("file") MultipartFile file) throws IOException, UserNotFoundException {
        FileDto fileDto = storageService.uploadFile(file, "picture_profile", securityService.getUser().getUid() + "-avatar");
        User user = userService.findByUid(securityService.getUser().getUid());
        user.setPicture(fileDto.getFileName());
        return ResponseEntity.ok(userDetailConverter.entityToDto(userService.saveUser(user)));
    }

    @GetMapping("/me")
    public ResponseEntity<User> me() throws UserNotFoundException {
        User userSecurity = securityService.getUser();
        User user = userService.findByUid(userSecurity.getUid());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchByUsername(@RequestParam String search) {
        return ResponseEntity.ok(userService.searchByUsername(search));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserDetailDto> getUserById(@PathVariable String uid) throws UserNotFoundException {
        return ResponseEntity.ok(userDetailConverter.entityToDto(userService.findByUid(uid)));
    }

}
