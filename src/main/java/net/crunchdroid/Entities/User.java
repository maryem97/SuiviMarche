package net.crunchdroid.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private  String role;
    private  String CIN;


    public User(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password,String role,Entreprise entreprise,Service service) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role=role;
        this.entreprise=entreprise;
        this.service=service;
    }

    @OneToOne
    Entreprise entreprise;

    @ManyToOne
    private Service service;
    @OneToMany
    List<Commentaire> commentaireList;
    @ManyToOne
    private Projet projet;
    @ManyToMany
    List<Tache> tacheList;


}
