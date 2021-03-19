package com.mabiereetmoi.api.beer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    public Beer save(Beer beer){
        return beerRepository.save(beer);
    }

    public Beer findById(Long id){
        return beerRepository.findById(id).get();
    }
}
