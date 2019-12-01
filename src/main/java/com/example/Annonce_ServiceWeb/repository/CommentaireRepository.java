package com.example.Annonce_ServiceWeb.repository;

import com.example.Annonce_ServiceWeb.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire , Integer> {
}
