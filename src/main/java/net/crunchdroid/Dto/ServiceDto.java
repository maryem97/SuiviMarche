package net.crunchdroid.Dto;

import lombok.Data;
import net.crunchdroid.Entities.Entreprise;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Data
public class ServiceDto {
    private String dropDownItem;
    private String nameService;
    private Long idEntreprise;
    @ManyToOne
    private Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}
