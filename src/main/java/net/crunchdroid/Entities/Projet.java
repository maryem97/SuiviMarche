package net.crunchdroid.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    @OneToMany
    List<Employe> employeList;
    @OneToMany
    List<Commentaire> commentaireList;
    @OneToMany
    List<Tache> tacheList;
    @ManyToOne
    private Service service;
}
