package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.EntrepriseDto;
import net.crunchdroid.Dto.ServiceDto;
import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Entities.Projet;
import net.crunchdroid.Entities.Service;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.EntrepriseService;
import net.crunchdroid.Services.ProjetService;
import net.crunchdroid.Services.UserService;
import net.crunchdroid.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projet")
public class ProjetController {

    @Autowired //Injection de dépendances
            ProjetService projetService;


    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Projet> listProjet = projetService.getAll();
        model.addAttribute("listProjet", listProjet);
        return "listProjet";
    }

}
