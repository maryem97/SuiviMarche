package net.crunchdroid.Services;


import net.crunchdroid.Dto.ServiceDto;
import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    EntrepriseService entrepriseService;

    public void saveService(ServiceDto serviceDto) throws Exception {
        Long idEntreprise= serviceDto.getIdEntreprise();
        Entreprise entrepriseById =entrepriseService.getEntrepriseById(idEntreprise);
        serviceRepository.save(new net.crunchdroid.Entities.Service(serviceDto.getNameService(),entrepriseById));


    }

    public List<net.crunchdroid.Entities.Service> getAll(Optional<Long> id) throws Exception {
        if(!id.isPresent())
            return serviceRepository.findAll();
        else {
            Entreprise entrepriseById = entrepriseService.getEntrepriseById(id.get());
            return serviceRepository.findByEntreprise(entrepriseById);
        }
    }
}
