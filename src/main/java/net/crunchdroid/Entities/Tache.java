package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class Tache {
    @Id
    @GeneratedValue
    private long id;

    private String numero;
    private String nomTache;
    private String description;
    private String dateDebutRealisation;
    private String dateFinaleRealisation;
    private String status;
    private String etatTache;

    @ManyToOne
    private Projet projet;

    @OneToMany
    List<Commentaire> commentaireList;

    @ManyToMany
    List<Employe> employeList;

    public Tache() {
    }


}

