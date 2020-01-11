package net.crunchdroid.Services;


import net.crunchdroid.Dto.EntrepriseDto;
import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    public boolean addEntreprise(EntrepriseDto entrepriseDto) {
        Entreprise entreprise=new Entreprise();
        entreprise.setName(entrepriseDto.getName());
        entrepriseRepository.save(entreprise);
        return true;
    }

    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    public void updateEntreprise(Long id, EntrepriseDto model) {
        Optional<Entreprise> byId = entrepriseRepository.findById(id);
        byId.get().setName(model.getName());

        entrepriseRepository.save(byId.get());
    }

    public Entreprise getEntrepriseById(Long id) throws Exception{
        Optional<Entreprise> entreprise= entrepriseRepository.findById(id);
        if(!entreprise.isPresent()) throw new Exception("We don't have any user with this id");
        return entreprise.get();
    }

    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    public Long getTotal(){
        return entrepriseRepository.count();
    }


    public List<net.crunchdroid.Entities.Service> servicesEntreprise(Long id){
        Entreprise one = entrepriseRepository.getOne(id);
        List<net.crunchdroid.Entities.Service> serviceList = one.getServiceList();
        return serviceList;

    }
}
