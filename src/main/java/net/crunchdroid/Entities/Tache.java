package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue
    private long id;

    private String numero;
    private String dateFinaleRealisation;
    private String etat;

    @ManyToOne
    private Projet projet;

}
