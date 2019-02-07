package com.myaudiolibrary.apirest.service;

import com.myaudiolibrary.apirest.exception.ArtistNameException;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    //Exercice 1
    public Artist findById(Long id)throws EntityNotFoundException {
        Artist artist= artistRepository.findOne(id);
        if(artist == null){
            throw new EntityNotFoundException("L'artiste d'identifiant : "+ id + " n'a pas été trouvé !");
        }
        return artist;
    }

    //exercice 2
    public Artist findByName(String name) throws EntityNotFoundException {
        Artist artist = artistRepository.findByName(name);
        if (artist == null){
            throw new EntityNotFoundException("L'artiste de nom : "+ name +" n'a pas été trouvé.");
        }
        return artist;
    }


    //Exercice 3
    public long countArtists (){
        return artistRepository.count();
    }

    public Page<Artist> findAllArtistPaging(Integer page, Integer size, String sortDirection, String sortProperty) throws
            IllegalArgumentException {
        // vérification du paramètre page
        if (page == null)
        {
            page = 0;
        }
        else if (page < 0)
        {
            throw new IllegalArgumentException("Le numéro de page ne peut être inférieur à 0 !");
        }
        else if (page > countArtists()/size )
        {
            throw new IllegalArgumentException("Le numéro de page ne peut être supérieur à " + ((countArtists()/size)+1) + " !");
        }
        PageRequest pageRequest = new PageRequest (page, size, Sort.Direction.fromString(sortDirection), sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    //Exercice 4
    public Artist nouvelArtist (Artist artist) throws ArtistNameException {
        //vérifier si le matricule existe en base
        if (artistRepository.findByName(artist.getName()) != null)
        {
            throw new ArtistNameException("Le nom " + artist.getName() + " existe déjà !");
        }
        return artistRepository.save(artist);
    }

    //Exercice 5
    public Artist modification(Long id, Artist artist) {
        return artistRepository.save(artist);
    }

    //Exercice 6
    public void suppression(Long id) {
        artistRepository.delete(id);
    }
}
