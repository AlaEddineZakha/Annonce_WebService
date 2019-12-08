package com.example.Annonce_ServiceWeb.Services;

import com.example.Annonce_ServiceWeb.Util.ErrorResponseModel;
import com.example.Annonce_ServiceWeb.model.Annonce;
import com.example.Annonce_ServiceWeb.model.Categorie;
import com.example.Annonce_ServiceWeb.repository.AnnonceRepository;
import com.example.Annonce_ServiceWeb.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;

    @Autowired
    CategorieRepository categorieRepository;

    public ResponseEntity<?> creatannonce(Annonce annonce){


        if ( annonce.getCategorie() != null)
        {
            //System.out.println(annonce.getCategorie().getId());
            Optional<Categorie> categorie = categorieRepository.findById(annonce.getCategorie().getId());
            //System.out.println("categorie" + categorie);
            if (!categorie.isPresent()){
                //System.out.println("categorie not found ");
                //System.out.println(categorie);
                //System.out.println(annonce.getCategorie() + " __ " + categorieRepository.findById(annonce.getCategorie().getId()));
                return new ResponseEntity<>( new ErrorResponseModel("Categorie not Found"), HttpStatus.BAD_REQUEST);
            }
        }
        try{
            annonce =  annonceRepository.save(annonce);
            return new ResponseEntity<>(annonce, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST);
        }

    }

    public List<Annonce> getAnnonces() {
        return annonceRepository.findAll();
    }

    public ResponseEntity<?>   getOneAnnonce( int id ){
        Optional<Annonce> annonceOptional=annonceRepository.findById(id);

        if(!annonceOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Annonce not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        try{
            Annonce destination = annonceOptional.get();
            return new ResponseEntity<>(destination, HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> deleteAnnonce( int id) {

        Optional<Annonce> annonceOptional = annonceRepository.findById(id);
        if (!annonceOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Annonce not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        try{
            annonceRepository.deleteById(id);
            return new ResponseEntity<>( new ErrorResponseModel("Annonce Deleted With Success") , HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> updateAnnonce( int id,  Annonce annonce) {
        Optional<Annonce> annonceOptional= annonceRepository.findById(id);

        if(!annonceOptional.isPresent()){
            ErrorResponseModel errorResponseModel = new ErrorResponseModel ("Annonce not found");
            return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
        }

        Annonce dataBaseAnnonce= annonceOptional.get();

        if(annonce.getTitre()!= null)
            dataBaseAnnonce.setTitre(annonce.getTitre());

        if(annonce.getDescription() != null)
            dataBaseAnnonce.setDescription(annonce.getDescription());
        if(annonce.getImage() != null)
            dataBaseAnnonce.setImage(annonce.getImage());
        if(annonce.getPrix() != null)
            dataBaseAnnonce.setPrix(annonce.getPrix());
        if(annonce.getEmplacement() != null)
            dataBaseAnnonce.setEmplacement(annonce.getEmplacement());
        //System.out.println(annonce.getCategorie());
        if(annonce.getCategorie() != null)
        {
            System.out.println(annonce.getCategorie().getId());
           Optional<Categorie> categorie = categorieRepository.findById(annonce.getCategorie().getId());
           //System.out.println("AZERTYUI" + categorie);
            if (categorie.isPresent()) {
                //System.out.println("JHGFD" + categorie);
                dataBaseAnnonce.setCategorie(annonce.getCategorie());
            }
            else {
                //System.out.println("NBVCXW" + categorie);
               return new ResponseEntity<>(new ErrorResponseModel ("Catégorie not found") ,HttpStatus.BAD_REQUEST  );
            }
        }
        try{
            annonceRepository.save(dataBaseAnnonce);
            return new ResponseEntity<>( new ErrorResponseModel("Anonnce Updated with success") , HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
