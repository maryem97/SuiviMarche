package net.crunchdroid.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue //automiquement
    private long id;

    private String name;

    @OneToMany
    List<Service> serviceList;

}
