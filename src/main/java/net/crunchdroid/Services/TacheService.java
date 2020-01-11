package net.crunchdroid.Services;


import net.crunchdroid.Repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;
}
