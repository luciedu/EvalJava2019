package com.myaudiolibrary.apirest.service;

import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository ;

    // ________________ A VERIFIER ____________________
    //Exercice 7
    public Album modification(Long id, Album album) {
        return albumRepository.save(album);
    }

    //Exercice 8
    public void suppression(Long id) {
        albumRepository.delete(id);
    }

}
