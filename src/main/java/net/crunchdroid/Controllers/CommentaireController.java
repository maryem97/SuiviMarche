package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.CommentaireDto;
import net.crunchdroid.Entities.Commentaire;
import net.crunchdroid.Services.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/commentaire")
public class CommentaireController {

    @Autowired //Injection de dépendances
    CommentaireService commentaireService;


    @GetMapping("/addCommentaire/{id}")
    public String addCommentaire(@PathVariable("id") Long id,Model model) {
        model.addAttribute("commentaire", new CommentaireDto());
        return "Commentaire/addCommentaire";
    }

    @PostMapping("/saveCommentaire")
    public String saveCommentaire(@ModelAttribute("commentaire") CommentaireDto model) {
        commentaireService.addCommentaire(model);
        return "redirect:/commentaire/getAll";
    }

    @GetMapping("/getAll/{id}")
    public String getAll(@PathVariable("id") Long id, Model model){
        Optional<Commentaire> listCommentaire = commentaireService.getAll(id);
        model.addAttribute("listCommentaire", listCommentaire);
        return "Commentaire/listCommentaire";
    }

    @RequestMapping("/updateCommentaire/{id}")
    public String updateCommentaire(@PathVariable("id") Long id,@ModelAttribute("commentaire") CommentaireDto model){
        commentaireService.updateCommentaire(id,model);
        return "redirect:/Commentaire/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editCommentaire(@PathVariable("id") Long id,Model model) throws Exception{
        Commentaire commentaire=  commentaireService.getCommentaireById(id);
        model.addAttribute("commentaire",commentaire);
        return "/Commentaire/editCommentaire";
    }

    @GetMapping("/delete/{id}")
    public String deleteCommentaire(@PathVariable("id") Long id){
        commentaireService.deleteCommentaire(id);
        return "redirect:/commentaire/getAll";
    }



}
