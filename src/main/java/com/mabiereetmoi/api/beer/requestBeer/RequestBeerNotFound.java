package com.mabiereetmoi.api.beer.requestBeer;

public class RequestBeerNotFound extends Exception {

    public RequestBeerNotFound(Long id) {
        super("Request beer not found " + id);
    }

}
