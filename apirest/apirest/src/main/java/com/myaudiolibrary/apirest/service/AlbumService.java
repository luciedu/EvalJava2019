package com.myaudiolibrary.apirest.service;

import com.myaudiolibrary.apirest.exception.DoublonException;
import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository ;


    //Exercice 7
    public Album ajout (Album album)throws DoublonException {
        if (albumRepository.findByTitle(album.getTitle())!= null){
            throw new DoublonException("le nom de l'album : "+album.getTitle()+" existe déjà");
        }
        return albumRepository.save(album);
    }

    //Exercice 8
    public void suppression(Long id) {
        albumRepository.delete(id);
    }

}
