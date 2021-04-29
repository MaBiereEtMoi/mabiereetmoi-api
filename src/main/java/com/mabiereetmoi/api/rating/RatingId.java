package com.mabiereetmoi.api.rating;

import lombok.Data;

import java.io.Serializable;

@Data
public class RatingId implements Serializable {

    private String user;
    private Long beer;

}
