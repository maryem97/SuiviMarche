package net.crunchdroid.Services;

import net.crunchdroid.Dto.EmployeDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Dto.UserRegistrationDto;
import net.crunchdroid.Entities.Employe;
import net.crunchdroid.Entities.Role;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeService {
    @Autowired
    EmployeRepository employeRepository;

    public boolean addEmploye(EmployeDto employe){
        employeRepository.save(new Employe(employe.getPrenom(),employe.getNom(),employe.getCIN(),employe.getRole()));
        return true;
    }
    public List<Employe> getAll(){
        return employeRepository.findAll();
    }





    public Employe save(EmployeDto registration){
        Employe employe = new Employe();
        employe.setPrenom(registration.getPrenom());
        employe.setNom(registration.getNom());
        employe.setCIN(registration.getCIN());
       // employe.setPassword(passwordEncoder.encode(registration.getPassword()));

        employe.setRole(registration.getRole());
/*
        Optional<Role> byId = roleRepository.findById(1);
        Set<Role> roles = new HashSet<>();
        //roles.add(new Role("USER"));
        roles.add(byId.get());
        user.setRoles(roles);
        */
        return employeRepository.save(employe);
    }
}
