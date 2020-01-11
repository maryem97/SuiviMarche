package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.SearchDto;
import net.crunchdroid.Dto.ServiceDto;
import net.crunchdroid.Entities.Service;
import net.crunchdroid.Repositories.ServiceRepository;
import net.crunchdroid.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;


    @GetMapping("/addService/{id}")
    public String addService(@PathVariable("id") Long idEntreprise, Model model){

        model.addAttribute("service",new ServiceDto());
        model.addAttribute("idEntreprise",idEntreprise);
        return "Entreprise/add_Service";
    }


    @PostMapping("/search")
    public String search(@ModelAttribute("serviceSearch") SearchDto serviceDto) throws Exception{
        String id = serviceDto.getId();

        return "redirect:/service/getAll?idEntreprise="+Long.parseLong(id);
    }

    @PostMapping("/saveService")
    public String saveService(@ModelAttribute("service") ServiceDto serviceDto) throws Exception{
        System.out.println(serviceDto.getIdEntreprise());
        System.out.println(serviceDto.getNameService());
        serviceService.saveService(serviceDto);
        return "redirect:/service/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(@RequestParam("idEntreprise") Optional<Long> id, Model model){
        try{
            List<Service> listService = serviceService.getAll(id);
            model.addAttribute("listService", listService);

            model.addAttribute("serviceSearch",new SearchDto());
            if(id.isPresent())
                model.addAttribute("idEntreprise",id.get());
            else
                model.addAttribute("idEntreprise","");
        }catch (Exception e){
            model.addAttribute("test",e.getMessage());
        }

        return "Entreprise/listService";
    }






}
