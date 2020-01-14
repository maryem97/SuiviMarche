package net.crunchdroid.Services;


import net.crunchdroid.Dto.PojetDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Dto.UserRegistrationDto;
import net.crunchdroid.Entities.Projet;
import net.crunchdroid.Entities.Role;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Repositories.ProjetRepository;
import net.crunchdroid.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {
    @Autowired
    ProjetRepository projetRepository;

    public List<Projet> getAll() {
        return projetRepository.findAll();
    }

    public boolean addProjet(PojetDto projet){
        projetRepository.save(new Projet(projet.getName(),projet.getService(),projet.getBudget()));
        return true;
    }


    public Projet save(PojetDto registration){
        Projet projet=new Projet();
        projet.setName(registration.getName());
        //projet.getEmployeList(registration.getEmployeList());
        projet.setService(registration.getService());
        projet.setBudget(registration.getBudget());
        return projetRepository.save(projet);
    }


    public Projet getProjetById(Long id) throws Exception{
        Optional<Projet> projet= projetRepository.findById(id);
        if(!projet.isPresent()) throw new Exception("We don't have any user with this id");
        return projet.get();
    }

    public boolean updateProjet(Long id,PojetDto model) {
        Optional<Projet> byId = projetRepository.findById(id);
        byId.get().setName(model.getName());
        byId.get().setEmployeList(model.getEmployeList());
        byId.get().setService(model.getService());
        byId.get().setBudget(model.getBudget());
        projetRepository.save(byId.get());
        return true;
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }


}
