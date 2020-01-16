package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Service {
    @Id
    @GeneratedValue
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    private String name;

    @ManyToOne
    private User chefService;

    @ManyToOne
    private Entreprise entreprise;
    @OneToMany
    List<Projet> projetList;
    @OneToMany
    List<Employe> employeList;

    public Service(){

    }
    public Service(String name, Entreprise entreprise) {
        this.name = name;
        this.entreprise = entreprise;
    }
}
