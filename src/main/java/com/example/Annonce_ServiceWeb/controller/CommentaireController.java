package com.example.Annonce_ServiceWeb.controller;

import com.example.Annonce_ServiceWeb.Services.CommentaireService;
import com.example.Annonce_ServiceWeb.model.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    CommentaireService commentaireService;

    @PostMapping("/create")
    public ResponseEntity<?> addCommentaire (@Valid @RequestBody Commentaire commentaire ){
        commentaire.setDate( new Date());
        return commentaireService.createCommentaire(commentaire);
    }

    @GetMapping("/annonce/{idannonce}/")
    public List<Commentaire> getCommentaireWithAnnonce(@PathVariable int idannonce){
        return commentaireService.getCommentaireWithAnnonce(idannonce);
    }

}
