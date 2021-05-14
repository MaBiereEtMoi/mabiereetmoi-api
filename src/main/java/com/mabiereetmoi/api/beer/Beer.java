package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import com.mabiereetmoi.api.comment.Comment;
import com.mabiereetmoi.api.rating.Rating;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Beer {

    @Id
    @GeneratedValue
    private Long idBeer;

    private String nameBeer;

    private Double note_avg;

    private Double degreeAlcohol;

    @Column(length=1000)
    private String description;

    private Date createDate;

    @ManyToOne
    private CategoryBeer category;

    @Lob
    @Column
    private byte[] image;

}
