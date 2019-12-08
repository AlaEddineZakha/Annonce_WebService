package com.example.Annonce_ServiceWeb.Services;

import com.example.Annonce_ServiceWeb.model.Categorie;
import com.example.Annonce_ServiceWeb.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie(){
        return categorieRepository.findAll();
    }
}
