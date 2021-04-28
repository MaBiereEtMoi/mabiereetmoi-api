package com.mabiereetmoi.api.favoriteBeer;

import lombok.Data;

import java.io.Serializable;

@Data
public class FavoriteBeerId implements Serializable {

    private String user;
    private Long beer;

}
