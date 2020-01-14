package net.crunchdroid.Services;


import net.crunchdroid.Dto.CommentaireDto;
import net.crunchdroid.Entities.Commentaire;
import net.crunchdroid.Repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;

    public boolean addCommentaire(CommentaireDto commentaire){
        commentaireRepository.save(new Commentaire(commentaire.getAddComment(),commentaire.getEmploye(),commentaire.getProjet(),commentaire.getTache()));
        return true;
    }
    public Optional<Commentaire> getAll(Long id) {
        return commentaireRepository.findById(id);
    }


    public Commentaire save(CommentaireDto registration) {
        Commentaire commentaire = new Commentaire();
        commentaire.setAddComment(registration.getAddComment());
        commentaire.setEmploye(registration.getEmploye());
        commentaire.setProjet(registration.getProjet());
        commentaire.setTache(registration.getTache());
        return commentaireRepository.save(commentaire);
    }

    public Commentaire getCommentaireById(Long id) throws Exception{
        Optional<Commentaire> commentaire= commentaireRepository.findById(id);
        if(!commentaire.isPresent()) throw new Exception("We don't have any commentaire with this id");
        return commentaire.get();
    }

    public boolean updateCommentaire(Long id,CommentaireDto model) {
        Optional<Commentaire> byId = commentaireRepository.findById(id);
        byId.get().setAddComment(model.getAddComment());
        byId.get().setEmploye(model.getEmploye());
        byId.get().setProjet(model.getProjet());
        byId.get().setTache(model.getTache());
        commentaireRepository.save(byId.get());
        return true;
    }

    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}
