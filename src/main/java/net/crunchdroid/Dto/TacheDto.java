package net.crunchdroid.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.crunchdroid.Entities.Projet;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TacheDto {
    @ManyToOne
    private Projet projet;
    @NotEmpty
    private  String numero;

    @NotEmpty
    private  String  nomTache;

    @NotEmpty
    private  String description;
    @NotEmpty
    private String dateDebutRealisation;

    @NotEmpty
    private String dateFinaleRealisation;

    @NotEmpty
    private String status;

    @NotEmpty
    private String etatTache;



    //getters

    public String getNumero() {
        return numero;
    }

    public String getNomTache() {
        return nomTache;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDebutRealisation() {
        return dateDebutRealisation;
    }

    public String getDateFinaleRealisation() {
        return dateFinaleRealisation;
    }

    public String getStatus() {
        return status;
    }

    public String getEtatTache() {
        return etatTache;
    }


    //setters

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebutRealisation(String dateDebutRealisation) {
        this.dateDebutRealisation = dateDebutRealisation;
    }

    public void setDateFinaleRealisation(String dateFinaleRealisation) {
        this.dateFinaleRealisation = dateFinaleRealisation;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setEtatTache(String etatTache) {
        this.etatTache = etatTache;
    }



}

