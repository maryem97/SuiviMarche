package net.crunchdroid.Services;


import net.crunchdroid.Dto.TacheDto;
import net.crunchdroid.Entities.Tache;
import net.crunchdroid.Repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;

    public boolean addTache(TacheDto tache){
        tacheRepository.save(new Tache(tache.getNumero(),tache.getNomTache(),tache.getDescription(),tache.getDateDebutRealisation(),tache.getDateFinaleRealisation(),tache.getStatus(),tache.getEtatTache()));
        return true;
    }
    public List<Tache> getAll() {
        return tacheRepository.findAll();
    }


    public Tache save(TacheDto registration) {
        Tache tache = new Tache();
        tache.setNumero(registration.getNumero());
        tache.setNomTache(registration.getNomTache());
        tache.setDescription(registration.getDescription());
        tache.setDateDebutRealisation(registration.getDateFinaleRealisation());
        tache.setStatus(registration.getStatus());
        tache.setEtatTache(registration.getEtatTache());

        return tacheRepository.save(tache);
    }

    public Tache getTacheById(Long id) throws Exception{
        Optional<Tache> tache= tacheRepository.findById(id);
        if(!tache.isPresent()) throw new Exception("We don't have any tache with this id");
        return tache.get();
    }

    public boolean updateTache(Long id,TacheDto model) {
        Optional<Tache> byId = tacheRepository.findById(id);
        byId.get().setNumero(model.getNumero());
        byId.get().setNomTache(model.getNomTache());
        byId.get().setDescription(model.getDescription());
        byId.get().setDateDebutRealisation(model.getDateDebutRealisation());
        byId.get().setDateFinaleRealisation(model.getDateFinaleRealisation());
        byId.get().setStatus(model.getStatus());
        byId.get().setEtatTache(model.getEtatTache());
        tacheRepository.save(byId.get());
        return true;
    }

    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }


}
