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
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    EmployeRepository employeRepository;

    public boolean addEmploye(EmployeDto employe){
        employeRepository.save(new Employe(employe.getPrenom(),employe.getNom(),employe.getCIN(),employe.getRole(),employe.getEmail(),employe.getPassword()));
        return true;
    }
    public List<Employe> getAll(){
        return employeRepository.findAll();
    }



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public Employe save(EmployeDto registration){
        Employe employe = new Employe();
        employe.setPrenom(registration.getPrenom());
        employe.setNom(registration.getNom());
        employe.setCIN(registration.getCIN());
        employe.setRole(registration.getRole());
        employe.setEmail(registration.getEmail());
        employe.setPassword(passwordEncoder.encode(registration.getPassword()));
/*
        Optional<Role> byId = roleRepository.findById(1);
        Set<Role> roles = new HashSet<>();
        //roles.add(new Role("USER"));
        roles.add(byId.get());
        user.setRoles(roles);
        */
        return employeRepository.save(employe);
    }


    public Employe getEmployeById(Long id) throws Exception{
        Optional<Employe> employe= employeRepository.findById(id);
        if(!employe.isPresent()) throw new Exception("We don't have any user with this id");
        return employe.get();
    }

    public boolean updateEmploye(Long id,EmployeDto model) {
        Optional<Employe> byId = employeRepository.findById(id);
        byId.get().setNom(model.getNom());
        byId.get().setPrenom(model.getPrenom());
        byId.get().setCIN(model.getCIN());
        byId.get().setRole(model.getRole());
        byId.get().setEmail(model.getEmail());
        byId.get().setPassword(model.getPassword());
        employeRepository.save(byId.get());
        return true;
    }

    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
