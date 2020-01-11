package net.crunchdroid.Services;


import net.crunchdroid.Repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
}
