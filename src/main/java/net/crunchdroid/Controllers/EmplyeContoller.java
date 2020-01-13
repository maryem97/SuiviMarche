package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.EmployeDto;
import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Entities.Employe;
import net.crunchdroid.Entities.Service;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.EmployeService;
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
    EmployeService employeService;

    @Autowired
    ServiceService serviceService;

    @GetMapping("/addEmploye")
    public String addEmploye(Model model) {
        model.addAttribute("employe", new Employe());
        List<Service> all = serviceService.getAll();
        List<String> nameUsers=new ArrayList<>();
        nameUsers.add("string1");
        nameUsers.add("string2");
        nameUsers.add("string3");
        nameUsers.add("string4");
        nameUsers.add("string5");
        nameUsers.add("string6");
        nameUsers.add("string7");
        model.addAttribute("listString",nameUsers);

        return "Employe/Add_Employe";
    }

    @PostMapping("/saveEmploye")
    public String saveEmploye(@ModelAttribute("employe") EmployeDto model) {
        employeService.addEmploye(model);
        String dropDownItem = model.getDropDownItem();
        System.out.println(dropDownItem);
        return "redirect:/employe/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Employe> listEmploye = employeService.getAll();
        model.addAttribute("listEmploye", listEmploye);
        return "Employe/Employes";
    }

    @RequestMapping("/updateEmploye/{id}")
    public String updateEmploye(@PathVariable("id") Long id,@ModelAttribute("employe") EmployeDto model){
        employeService.updateEmploye(id,model);
        return "redirect:/employe/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editEmploye(@PathVariable("id") Long id,Model model) throws Exception{
        Employe employe=  employeService.getEmployeById(id);
        model.addAttribute("employe",employe);

        return "/Employe/editEmploye";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable("id") Long id){
        employeService.deleteEmploye(id);
        return "redirect:/employe/getAll";
    }


    @PostMapping("/addDirecteur")
    public String saveDirecteur(@ModelAttribute("employe") EmployeDto model) {
        employeService.addDirecteur(model);
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
    }
//il faut que vous relger tout ca
    /*7
   associer f création les choes entre elle
   laisser soit talble  emploer soit table user
   ajouter boutoon cration user et jouer avec les roles
   ensuite
   stp vous travaillez ca d'ici sbah et après je traite avec toi l partie tache et authorization
   est ce
     */
}
