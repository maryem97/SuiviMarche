package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue //automiquement
    private long id;

    private String name;

    @ManyToOne
    private User directeur;

    @OneToMany
    List<Service> serviceList;

}
