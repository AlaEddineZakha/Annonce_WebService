package com.example.Annonce_ServiceWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min=3, max = 50)
    private String Nom;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "categorie")
    private List<Annonce> annonce;


/*Immobilier ,
    Véhicules ,
    Maision et Jardin ,
    Loisir et Divertissement ,
    Informatique et Multimedia ,
    Emploi et service ,
    Habillement et Bien Etre ,
    Entreprises ,
    Autre*/
}
