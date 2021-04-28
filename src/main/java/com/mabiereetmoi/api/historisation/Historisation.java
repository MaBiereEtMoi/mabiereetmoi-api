package com.mabiereetmoi.api.historisation;

import com.mabiereetmoi.api.beer.Beer;
import com.mabiereetmoi.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Historisation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Beer beer;

    @ManyToOne
    private User user;

    private Long createdAt;

}
