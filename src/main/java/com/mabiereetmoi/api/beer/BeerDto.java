package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.beer.categoryBeer.CategoryBeer;
import com.mabiereetmoi.api.comment.Comment;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Builder
public class BeerDto {

    private Long id_beer;
    private String nameBeer;
    private List<Comment> comments;
    private Double note_avg;
    private Double degreeAlcohol;
    private String description;
    private Date createDate;
    private CategoryBeer category;
    private byte[] image;
    private boolean isFavorite;

}
