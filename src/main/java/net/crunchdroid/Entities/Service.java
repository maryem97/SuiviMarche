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

    private String name;

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
