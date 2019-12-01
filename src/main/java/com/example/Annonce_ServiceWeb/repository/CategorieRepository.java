package com.example.Annonce_ServiceWeb.repository;

import com.example.Annonce_ServiceWeb.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
