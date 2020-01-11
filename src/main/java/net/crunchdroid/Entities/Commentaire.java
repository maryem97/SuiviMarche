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
public class Commentaire {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Projet projet;

}
