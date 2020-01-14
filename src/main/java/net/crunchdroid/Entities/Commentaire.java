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
    private String addComment;

    public Commentaire(String addComment, Employe employe, Projet projet, Tache tache) {
        this.addComment = addComment;
        this.employe = employe;
        this.projet = projet;
        this.tache = tache;
    }

    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Projet projet;
    @ManyToOne
    private Tache tache;
    

}
