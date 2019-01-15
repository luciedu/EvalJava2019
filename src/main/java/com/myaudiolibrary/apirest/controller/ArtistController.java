package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/artists")

public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist FindArtist(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return artistRepository.findOne(id);
    }
}