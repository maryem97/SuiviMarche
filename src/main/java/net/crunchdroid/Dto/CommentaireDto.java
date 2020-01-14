package net.crunchdroid.Dto;

import lombok.Data;
import net.crunchdroid.Entities.Employe;
import net.crunchdroid.Entities.Projet;
import net.crunchdroid.Entities.Tache;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Data
public class CommentaireDto {
    @NotEmpty
    private String addComment;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Projet projet;
    @ManyToOne
    private Tache tache;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
//Getters et setters

    public String getAddComment() {
        return addComment;
    }

    public void setAddComment(String addComment) {
        this.addComment = addComment;
    }
}
