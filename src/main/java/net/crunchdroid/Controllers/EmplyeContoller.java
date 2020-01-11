package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.EmployeDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Entities.Employe;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.EmployeService;
import net.crunchdroid.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/employe")
public class EmplyeContoller {

    @Autowired
    EmployeService employeService;

    @GetMapping("/addEmploye")
    public String addEmploye(Model model) {
        model.addAttribute("employe", new Employe());
        return "Employe/Add_Employe";
    }

    @PostMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") EmployeDto model) {

        employeService.addEmploye(model);
        return "redirect:/employe/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Employe> listEmploye = employeService.getAll();
        model.addAttribute("listEmploye", listEmploye);
        return "Employe/listEmploye";
    }

}
