package net.crunchdroid.Services;


import net.crunchdroid.Entities.Projet;
import net.crunchdroid.Repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    ProjetRepository projetRepository;

    public List<Projet> getAll() {
        return projetRepository.findAll();
    }
}
