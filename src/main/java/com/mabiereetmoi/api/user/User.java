package com.mabiereetmoi.api.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
