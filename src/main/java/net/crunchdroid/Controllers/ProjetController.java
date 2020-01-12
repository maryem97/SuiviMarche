package net.crunchdroid.Controllers;

import net.crunchdroid.Entities.Employe;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class ProjetController {
    @GetMapping("/getAll")
    public String getAll(Model model){

        return "Employe/listEmploye";
    }
}
