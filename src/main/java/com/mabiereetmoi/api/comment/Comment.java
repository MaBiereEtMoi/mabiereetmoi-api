package com.mabiereetmoi.api.comment;

import com.mabiereetmoi.api.rating.Rating;
import com.mabiereetmoi.api.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long idComment;

    @ManyToOne
    private User user;

    private String message;
}
