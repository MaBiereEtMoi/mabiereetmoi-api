package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String uid;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String picture;
    private String issuer;
    private boolean emailVerified;

    @OneToMany
    private List<Beer> beersFavorite;

}
