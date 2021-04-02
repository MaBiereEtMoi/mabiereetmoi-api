package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.comment.Comment;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Beer {

    @Id
    @GeneratedValue
    private Long id_beer;

    private String nameBeer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    private Double note_avg;

    private Double degreeAlcohol;

    private String description;

    private Date createDate;

    @ManyToOne
    private CategoryBeer category;


}
