package com.mabiereetmoi.api.beer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;

    public Beer save(Beer beer){
        return beerRepository.save(beer);
    }

    public Beer findById(Long id) throws BeerNotFoundException {
        return beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
    }

    public List<Beer> findAll(){
        return beerRepository.findAll();
    }
}
