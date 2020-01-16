package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.EmployeDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Dto.UserRegistrationDto;
import net.crunchdroid.Entities.Employe;
import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Entities.Service;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.EmployeService;
import net.crunchdroid.Services.EntrepriseService;
import net.crunchdroid.Services.ServiceService;
import net.crunchdroid.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.CompositeData;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/employe")
public class EmplyeContoller {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    EntrepriseService entrepriseService;
    @GetMapping("/addEmploye")
    public String addEmploye(Model model) {
        model.addAttribute("user", new UserDto());
        List<Service> all = serviceService.getAll();
        model.addAttribute("listString",all);


        List<Entreprise> allEntreprise = entrepriseService.getAll();
        model.addAttribute("listEntreprise",allEntreprise);

        List<String> role = new ArrayList<>();
        role.add("Employe");
        model.addAttribute("listRole",role);


        return "Employe/Add_Employe";
    }

    @PostMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("user") UserRegistrationDto model) {

            userService.addUser(model);
        return "redirect:/employe/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<User> listUser = userService.getAll();
        model.addAttribute("listUser", listUser);
        return "Employe/Employes";
    }

    @RequestMapping("/updateEmploye/{id}")
    public String updateEmploye(@PathVariable("id") Long id,@ModelAttribute("user") UserDto model){
        userService.updateUser(id,model);
        return "redirect:/employe/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editEmploye(@PathVariable("id") Long id,Model model) throws Exception{
        User user=  userService.getUserById(id);
        model.addAttribute("user",user);
        List<Service> all = serviceService.getAll();
        model.addAttribute("listString",all);


        List<Entreprise> allEntreprise = entrepriseService.getAll();
        model.addAttribute("listEntreprise",allEntreprise);

        List<String> role = new ArrayList<>();
        role.add("Employe");
        model.addAttribute("listRole",role);


        return "/Employe/editEmploye";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/employe/getAll";
    }


  /*  @PostMapping("/addDirecteur")
    public String saveDirecteur(@ModelAttribute("employe") EmployeDto model) {
        userService.addDirecteur(model);
        String dropDownItem = model.getDropDownItem();
        System.out.println(dropDownItem);
        return "redirect:/employe/getAll";
    }

    @PostMapping("/addChefService")
    public String saveChefService(@ModelAttribute("employe") EmployeDto model) {
        employeService.addChefService(model);
        String dropDownItem = model.getDropDownItem();
        System.out.println(dropDownItem);
        return "redirect:/employe/getAll";
    }*/

}
