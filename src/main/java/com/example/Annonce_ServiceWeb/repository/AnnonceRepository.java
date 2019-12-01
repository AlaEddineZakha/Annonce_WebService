package com.example.Annonce_ServiceWeb.repository;

import com.example.Annonce_ServiceWeb.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}
