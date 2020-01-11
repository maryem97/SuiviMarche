package net.crunchdroid.Controllers;


import net.crunchdroid.Dto.EntrepriseDto;
import net.crunchdroid.Dto.ServiceDto;
import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Entities.Service;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.EntrepriseService;
import net.crunchdroid.Services.UserService;
import net.crunchdroid.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired //Injection de dépendances
    EntrepriseService entrepriseService;

    @Autowired
    UserServiceImpl userService;
     //dto des objects envoyés par Front et récupérer par Controller
    // et vice versa
    //ajouterEntreprise
    @GetMapping("/createEntreprise")
    public String createEntreprise(Model model){
        model.addAttribute("entreprise",new EntrepriseDto());
        List<User> all = userService.getAll();
        List<String> nameUsers=new ArrayList<>();
        nameUsers.add("string1");
        nameUsers.add("string2");
        nameUsers.add("string3");
        nameUsers.add("string4");
        nameUsers.add("string5");
        nameUsers.add("string6");
        nameUsers.add("string7");

        model.addAttribute("listString",all);
        return "Entreprise/add_Entreprise";
    }

    @PostMapping("/saveEntreprise")
    public String addEntreprise(@ModelAttribute("entreprise") EntrepriseDto entrepriseDto){
      entrepriseService.addEntreprise(entrepriseDto);
        String dropDownItem = entrepriseDto.getDropDownItem();
        System.out.println(dropDownItem);
        return "redirect:/entreprise/getAll";
    }



    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Entreprise> listEntreprise = entrepriseService.getAll();
        model.addAttribute("listEntreprise", listEntreprise);
        return "Entreprise/listEntreprise";
    }

    @RequestMapping("/updateEntreprise/{id}")
    public String updateEntreprise(@PathVariable("id") Long id,@ModelAttribute("entreprise") EntrepriseDto model){
        entrepriseService.updateEntreprise(id,model);
        return "redirect:/entreprise/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editEntreprise(@PathVariable("id") Long id,Model model) throws Exception{
        Entreprise entreprise=  entrepriseService.getEntrepriseById(id);
        model.addAttribute("entreprise",entreprise);

        return "Entreprise/editEntreprise";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntreprise(@PathVariable("id") Long id){
        entrepriseService.deleteEntreprise(id);
        return "redirect:/entreprise/getAll";
    }

    @GetMapping("/{id}/services")
    public String servicesEntreprise(@PathVariable("id") Long id,Model model){
        List<Service> services = entrepriseService.servicesEntreprise(id);
        model.addAttribute("listService", services);
        model.addAttribute("total",id);
        return "redirect:/service/getAll?idEntreprise="+id;
    }


    //supprimerEntreprise

    //getAllEntrepriseWithCriteria
}
