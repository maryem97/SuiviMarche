package net.crunchdroid.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.crunchdroid.Entities.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojetDto {

    @OneToMany
    List<User> employeList;
    @OneToMany
    List<Commentaire> commentaireList;
    @OneToMany
    List<Tache> tacheList;
    @ManyToOne
    private Service service;
    @NotEmpty
    private String name;

    @NotEmpty
    private float budget;



    public List<User> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<User> employeList) {
        this.employeList = employeList;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }






    public String getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(String etatProjet) {
        this.etatProjet = etatProjet;
    }

    @NotEmpty
    private String etatProjet;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @NotEmpty
    private String etat;
    public List<Tache> getTacheList() {
        return tacheList;
    }

    public void setTacheList(List<Tache> tacheList) {
        this.tacheList = tacheList;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
