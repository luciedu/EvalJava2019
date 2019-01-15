package com.myaudiolibrary.apirest.service;
import com.myaudiolibrary.apirest.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ArtistRepository {

    @Autowired
    ArtistRepository artistRepository;

    public Artist FindById (Long id) throws EntityNotFoundException{
        Artist artist = artistRepository.FindById(id);
        if (artist == null){
            throw new EntityNotFoundException("L'artiste d'identifiant : "+ id +" n'a pas été trouvé.");
        }
        return artist;
    }

}
