package com.mabiereetmoi.api.beer;

public class BeerNotFoundException extends Exception {

    public BeerNotFoundException(Long beerId) {
        super("Beer " + beerId + " not found");
    }

}
