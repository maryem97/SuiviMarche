package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Employe {

    @Id
    @GeneratedValue
     private  long id;

     private  String nom;
     private  String  prenom;
     private  String CIN;
     private  String role;

     @ManyToOne
    private Service service;
     @OneToMany
    List<Commentaire> commentaireList;
     @ManyToOne
    private Projet projet;


}
