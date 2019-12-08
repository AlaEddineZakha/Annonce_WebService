package com.example.Annonce_ServiceWeb.controller;

import com.example.Annonce_ServiceWeb.Services.AnnonceService;
import com.example.Annonce_ServiceWeb.model.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;

    @PostMapping("/create")
    public ResponseEntity<?> addAnnonce(@Valid @RequestBody Annonce annonce) {
        annonce.setDate(new Date());
        //annonce.setTrash(0);
        return annonceService.creatannonce(annonce);
    }

    @GetMapping("/all")
    public List<Annonce> AllAnnonce(){
        return annonceService.getAnnonces();
    }

    @GetMapping("/{id}/view")
    public ResponseEntity<?> getOneAnnonce(@PathVariable int id ){

        return annonceService.getOneAnnonce(id);
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteAnnonce(@PathVariable int id)
    {
        return annonceService.deleteAnnonce(id);
    }


    @PutMapping("/{id}/edit")
    public ResponseEntity<?> updateAnnonce(@PathVariable int id, @RequestBody Annonce annonce)
    {
        return annonceService.updateAnnonce(id,annonce);
    }
}
