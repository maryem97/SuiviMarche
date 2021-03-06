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

    public Projet(String name,Service service,float budget,String etatProjet) {
        this.name=name;
       // this.employeList=employeList;
        this.service=service;
        this.budget=budget;
        this.etatProjet=etatProjet;

    }

    public Projet() {

    }


    public void getEmployeList(List<User> employeList) {
        this.employeList=employeList;

    }
}
