package net.crunchdroid.Services;


import net.crunchdroid.Entities.Tache;
import net.crunchdroid.Repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;

    public List<Tache> getAll() {
        return tacheRepository.findAll();
    }
}
