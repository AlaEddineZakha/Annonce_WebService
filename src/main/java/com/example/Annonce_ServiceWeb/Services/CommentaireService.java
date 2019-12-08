package com.example.Annonce_ServiceWeb.Services;

import com.example.Annonce_ServiceWeb.Util.ErrorResponseModel;
import com.example.Annonce_ServiceWeb.model.Annonce;
import com.example.Annonce_ServiceWeb.model.Commentaire;
import com.example.Annonce_ServiceWeb.model.User;
import com.example.Annonce_ServiceWeb.repository.AnnonceRepository;
import com.example.Annonce_ServiceWeb.repository.CommentaireRepository;
import com.example.Annonce_ServiceWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    AnnonceRepository annonceRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> createCommentaire (@Valid @RequestBody Commentaire commentaire){

        // Si Le Contenu du Commentaire Vide
        if (commentaire.getContenu() == ""){
            return new ResponseEntity<>( new ErrorResponseModel(" Commentaire Invalid 'null' "), HttpStatus.BAD_REQUEST);
        }
        // Si l'id d'annonce n'existe
        if ( commentaire.getAnnonce() != null){
            Optional<Annonce> annonce = annonceRepository.findById(commentaire.getAnnonce().getId());
            // Si l'object Annonce n'existe
            if ( !annonce.isPresent()){
                return new ResponseEntity<>(new ErrorResponseModel("Annonce Not Found "), HttpStatus.BAD_REQUEST);
            }
        }
        // Si l'id de Commentaire n'existe
        if (commentaire.getUser() != null){
            Optional<User> user = userRepository.findById(commentaire.getUser().getId());
            // Si l'object Commentaire n'existe
            if (!user.isPresent()){
                return new ResponseEntity<>(new ErrorResponseModel("User Not Found"), HttpStatus.BAD_REQUEST);
            }
        }
        try {
            commentaire = commentaireRepository.save(commentaire);
            return new ResponseEntity<>(commentaire , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Another Error : " +e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<Commentaire> getCommentaireWithAnnonce(@PathVariable int idannonce){
        return commentaireRepository.getByIdAnnonce(idannonce);
    }
}
