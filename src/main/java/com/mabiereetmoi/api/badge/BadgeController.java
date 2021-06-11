package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/badge")
@AllArgsConstructor
public class BadgeController {

    private final BadgeScanService badgeScanService;
    private final BadgeCommentService badgeCommentService;
    private final BadgeAddBeerService badgeAddBeerService;
    private final BadgeBeerFavService badgeBeerFavService;
    private final BadgeService badgeService;

    @GetMapping
    public ResponseEntity<List<Badge>> getAllBadges(){
        return ResponseEntity.ok(badgeService.getAllBadges());
    }

    @GetMapping("/checkScanBadges")
    public ResponseEntity<Badge> getBadgeScanIfUnlocked(@RequestParam String userId) throws UserNotFoundException {
        return ResponseEntity.ok(badgeScanService.check(userId));
    }

    @GetMapping("/checkCommentsBadges")
    public ResponseEntity<Badge> getBadgeCommentIfUnlocked(@RequestParam String userId) throws UserNotFoundException {
        return ResponseEntity.ok(badgeCommentService.check(userId));
    }

    @GetMapping("/checkBeerAddedBadges")
    public ResponseEntity<Badge> getBadgeBeerAddedIfUnlocked(@RequestParam String userId) throws UserNotFoundException {
        return ResponseEntity.ok(badgeAddBeerService.check(userId));
    }

    @GetMapping("/checkBeerFavBadges")
    public ResponseEntity<Badge> getBadgeBeerFavIfUnlocked(@RequestParam String userId) throws UserNotFoundException {
        return ResponseEntity.ok(badgeBeerFavService.check(userId));
    }
}
