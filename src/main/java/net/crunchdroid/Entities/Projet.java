package net.crunchdroid.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Projet {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String etatProjet;
    private float budget;

    @OneToMany
    List<User> employeList;
    @OneToMany
    List<Commentaire> commentaireList;
    @OneToMany
    List<Tache> tacheList;
    @ManyToOne
    private Service service;

    public Projet(String name, List<User> employeList,Service service,float budget) {
        this.name=name;
        this.employeList=employeList;
        this.service=service;
        this.budget=budget;

    }

    public Projet() {

    }


}
