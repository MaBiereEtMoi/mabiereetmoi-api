package com.mabiereetmoi.api.beer.requestBeer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestBeerService {

    private final RequestBeerRepository requestBeerRepository;

    public RequestBeer saveRequestBeer(RequestBeer requestBeer) {
        return this.requestBeerRepository.save(requestBeer);
    }

    public Integer getNbRequestBeer() {
        return requestBeerRepository.countAllByPending(true);
    }

    public List<RequestBeer> getAllRequestsBeer() {
        return requestBeerRepository.findAll();
    }

    public RequestBeer findRequestBeerById(Long requestId) throws RequestBeerNotFound {
        return requestBeerRepository.findById(requestId).orElseThrow(() -> new RequestBeerNotFound(requestId));
    }

}
