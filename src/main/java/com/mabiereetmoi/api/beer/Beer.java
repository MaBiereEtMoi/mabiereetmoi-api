package com.mabiereetmoi.api.beer;

import com.mabiereetmoi.api.comment.Comment;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Beer {

    @Id
    @GeneratedValue
    private Long id_beer;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    private Double note_avg;


}
