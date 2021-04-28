package com.mabiereetmoi.api.historisation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorisationRepository extends CrudRepository<Historisation, Long> {

    List<Historisation> findAllByUserUid(String uid);

}
