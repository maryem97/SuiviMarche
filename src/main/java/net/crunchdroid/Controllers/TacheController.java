package net.crunchdroid.Controllers;


import net.crunchdroid.Dto.EntrepriseDto;
import net.crunchdroid.Dto.ServiceDto;
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


    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Tache> listTache = tacheService.getAll();
        model.addAttribute("listTache", listTache);
        return "listTache";
    }


}
