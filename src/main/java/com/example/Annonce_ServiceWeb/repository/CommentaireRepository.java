package com.example.Annonce_ServiceWeb.repository;

import com.example.Annonce_ServiceWeb.model.Annonce;
import com.example.Annonce_ServiceWeb.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire , Integer> {


    @Query(value = "SELECT * FROM Commentaire C WHERE  C.annonce = :idannonce ", nativeQuery = true)
    List<Commentaire> getByIdAnnonce(@Param("idannonce") int idannonce);
}
