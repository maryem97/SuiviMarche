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


    public net.crunchdroid.Entities.Service saveService(ServiceDto serviceDto){
        net.crunchdroid.Entities.Service service=new net.crunchdroid.Entities.Service();
        service.setName(serviceDto.getNameService());
        service.setEntreprise(serviceDto.getEntreprise());
       return serviceRepository.save(service);


    }

    public List<net.crunchdroid.Entities.Service> getAll(){
        return serviceRepository.findAll();
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
