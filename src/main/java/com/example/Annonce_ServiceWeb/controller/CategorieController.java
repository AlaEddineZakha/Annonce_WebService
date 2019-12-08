package com.example.Annonce_ServiceWeb.controller;

import com.example.Annonce_ServiceWeb.Services.CategorieService;
import com.example.Annonce_ServiceWeb.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/all")
    public List<Categorie> getAllCategorie(){
        return categorieService.getAllCategorie();
    }
}
