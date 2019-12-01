package com.example.Annonce_ServiceWeb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min=3, max = 50)
    private String titre;

    @NotBlank
    @Size(min=10, max = 200)
    private String description;

    @NotBlank
    private String image;

    private Float prix;

    @NotBlank
    private String emplacement;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "Categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    //private int trash;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "annonce")
    private Collection<Commentaire> commentaire;

}
