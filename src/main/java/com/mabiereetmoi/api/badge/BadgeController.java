package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/badge")
public class BadgeController {

    private BadgeScanService badgeScanService;

    @GetMapping("/checkScanBadges")
    public ResponseEntity<Badge> getBadgeIfUnlocked(@RequestParam String userId){
        badgeScanService = new BadgeScanService(new UserService());
    }
}
