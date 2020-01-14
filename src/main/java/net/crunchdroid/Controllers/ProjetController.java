package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.EntrepriseDto;
import net.crunchdroid.Dto.PojetDto;
import net.crunchdroid.Dto.ServiceDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Entities.*;
import net.crunchdroid.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projet")
public class ProjetController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    UserServiceImpl userService;

    @Autowired //Injection de dépendances
            ProjetService projetService;


    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Projet> listProjet = projetService.getAll();
        model.addAttribute("listProjet", listProjet);
        return "listProjet";
    }

    @GetMapping("/addProjet")
    public String addProjet(Model model) {
        model.addAttribute("projet", new PojetDto());
        List<Service> all = serviceService.getAll();
        model.addAttribute("listService",all);

        List<User> allEmploye = userService.getAll();
        model.addAttribute("listEmploye",allEmploye);

        List<String> etat = new ArrayList<>();
        etat.add("no validate");
        model.addAttribute("listetat",etat);

        return "Projet/Add_Projet";
    }

    @PostMapping("/saveProjet")
    public String saveProjet(@ModelAttribute("projet") PojetDto model) {

        projetService.addProjet(model);
        return "redirect:/projet/getAll";
    }

    @RequestMapping("/updateProjet/{id}")
    public String updateProjet(@PathVariable("id") Long id,@ModelAttribute("projet") PojetDto model){
        projetService.updateProjet(id,model);
        return "redirect:/projet/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editProjet(@PathVariable("id") Long id,Model model) throws Exception{
        Projet projet=  projetService.getProjetById(id);
        model.addAttribute("projet",projet);

        List<Service> all = serviceService.getAll();
        model.addAttribute("listService",all);

        List<User> allEmploye = userService.getAll();
        model.addAttribute("listEmploye",allEmploye);
        List<String> etat = new ArrayList<>();

        return "Projet/editProjet";
    }

    @GetMapping("/delete/{id}")
    public String deleteProjet(@PathVariable("id") Long id){
        projetService.deleteProjet(id);
        return "redirect:/projet/getAll";
    }

}
