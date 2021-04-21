package com.mabiereetmoi.api.beer.requestBeer;

import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/requestBeer")
public class RequestBeerController {

    private final RequestBeerService requestBeerService;
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<RequestBeer> saveRequestBeer(@RequestBody RequestBeer requestBeer) {
        requestBeer.setSender(securityService.getUser());
        requestBeer.setCreatedAt(LocalDateTime.now().toEpochSecond(ZoneId.of("Europe/Paris").getRules().getOffset(LocalDateTime.now())));
        requestBeer.setPending(true);
        return ResponseEntity.ok(requestBeerService.saveRequestBeer(requestBeer));
    }

    @GetMapping("/notification")
    public ResponseEntity<Integer> getNbRequestBeer() {
        return ResponseEntity.ok(requestBeerService.getNbRequestBeer());
    }

    @GetMapping
    public ResponseEntity<List<RequestBeer>> getAllRequestsBeer() {
        return ResponseEntity.ok(requestBeerService.getAllRequestsBeer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestBeer> findById(@PathVariable("id") Long id) throws RequestBeerNotFound {
        return ResponseEntity.ok(requestBeerService.findRequestBeerById(id));
    }

}
