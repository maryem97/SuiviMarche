package net.crunchdroid.Services;


import net.crunchdroid.Repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetService {
    @Autowired
    ProjetRepository projetRepository;
}
