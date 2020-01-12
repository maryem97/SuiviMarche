package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Employe {

    @Id
    @GeneratedValue
     private  long id;

     private  String nom;
     private  String  prenom;
     private  String CIN;
     private  String role;
    private String email;
    private String password;

     @ManyToOne
    private Service service;
     @OneToMany
    List<Commentaire> commentaireList;
     @ManyToOne
    private Projet projet;
     @ManyToMany
     List<Tache> tacheList;

     public Employe(){

     }

    public Employe(String prenom ,String nom,  String cin, String role,String email, String password) {
        this.prenom=prenom;
        this.nom=nom;
        this.CIN=cin;
        this.role=role;
        this.email = email;
        this.password = password;
    }
}
