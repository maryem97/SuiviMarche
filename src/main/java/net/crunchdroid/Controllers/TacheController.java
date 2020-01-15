package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.TacheDto;
import net.crunchdroid.Entities.*;
import net.crunchdroid.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tache")
public class TacheController {

    @Autowired //Injection de dépendances
            TacheService tacheService;
    @Autowired
    ProjetService projetService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/addTache")
    public String addTache(Model model) {
        model.addAttribute("tache", new TacheDto());
        List<String> status = new ArrayList<>();
        status.add("To Do");
        status.add("En Cours");
        status.add("Terminé");
        model.addAttribute("listStatus",status);

        List<Projet> projets = projetService.getAll();
        model.addAttribute("listProjet",projets);

        List<User> allEmploye = userService.getAll();
        model.addAttribute("listEmploye",allEmploye);

        return "Tache/addTache";
    }

    @PostMapping("/saveTache")
    public String saveTache(@ModelAttribute("tache") TacheDto model) {
        tacheService.addTache(model);
        return "redirect:/tache/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Tache> listTache = tacheService.getAll();
        model.addAttribute("listTache", listTache);
        return "Tache/listTache";
    }

    @RequestMapping("/updateTache/{id}")
    public String updateTache(@PathVariable("id") Long id,@ModelAttribute("tache") TacheDto model){
        tacheService.updateTache(id,model);
        return "redirect:/Tache/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editTache(@PathVariable("id") Long id,Model model) throws Exception{
        Tache tache=  tacheService.getTacheById(id);
        model.addAttribute("tache",tache);
        //model.addAttribute("tache", new TacheDto());
        List<String> status = new ArrayList<>();
        status.add("To Do");
        status.add("En Cours");
        status.add("Terminé");
        model.addAttribute("listStatus",status);

        List<Projet> projets = projetService.getAll();
        model.addAttribute("listProjet",projets);
        List<String> etat = new ArrayList<>();
        etat.add("Valide");
        etat.add("Invalide");
        model.addAttribute("listEtat",etat);

        return "/Tache/editTache";
    }

    @GetMapping("/delete/{id}")
    public String deleteTache(@PathVariable("id") Long id){
        tacheService.deleteTache(id);
        return "redirect:/tache/getAll";
    }


}
