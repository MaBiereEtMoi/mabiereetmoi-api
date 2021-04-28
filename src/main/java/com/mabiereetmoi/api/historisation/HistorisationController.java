package com.mabiereetmoi.api.historisation;

import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/historisation")
public class HistorisationController {

    private final HistorisationService historisationService;
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<Historisation> saveHistorisation(@RequestBody Beer beer) {
        Historisation historisation = Historisation.builder()
                .beer(beer)
                .user(securityService.getUser())
                .createdAt(LocalDateTime.now().toEpochSecond(ZoneId.of("Europe/Paris").getRules().getOffset(LocalDateTime.now()))).build();
        return ResponseEntity.ok(historisationService.saveHistorisation(historisation));
    }

    @GetMapping
    public ResponseEntity<List<Historisation>> getHistorisation() {
        return ResponseEntity.ok(historisationService.getHistorisationByUser(securityService.getUser().getUid()));
    }

}
