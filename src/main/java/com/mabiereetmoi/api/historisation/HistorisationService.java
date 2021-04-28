package com.mabiereetmoi.api.historisation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistorisationService {

    private final HistorisationRepository historisationRepository;

    public Historisation saveHistorisation(Historisation historisation) {
        return historisationRepository.save(historisation);
    }

    public List<Historisation> getHistorisationByUser(String uid) {
        return historisationRepository.findAllByUserUid(uid);
    }

}
