package com.mabiereetmoi.api.user;

import com.mabiereetmoi.api.badge.Badge;
import com.mabiereetmoi.api.beer.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.annotation.Nullable;
import javax.persistence.*;
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
    private Boolean isAdmin;

    @OneToMany
    private List<Badge> badges;

}
