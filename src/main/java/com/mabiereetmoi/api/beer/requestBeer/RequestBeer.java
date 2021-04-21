package com.mabiereetmoi.api.beer.requestBeer;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import com.mabiereetmoi.api.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class RequestBeer {

    @Id
    @GeneratedValue
    private Long id;

    private String barcode;
    private String name;
    private Double degreeAlcohol;

    @ManyToOne
    private User sender;

    @ManyToOne
    private CategoryBeer category;

    private Long createdAt;
    private Boolean pending;
}
