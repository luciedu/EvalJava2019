package com.myaudiolibrary.apirest.controller;

import com.myaudiolibrary.apirest.exception.ArtistNameException;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/artists")
public class ArtistController
{

    @Autowired
    ArtistService artistService;

    //Exercice 1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces ="application/json")
    public Artist trouverArtist(@PathVariable(value = "id") Long id) throws EntityNotFoundException
    {
        return artistService.findById(id);
    }

    //Exercice 2
    @RequestMapping (params = "name") //si dans la requete on a un parametre matricule on ira directement ici
    public Artist findByMatricule (@RequestParam("name") String name) throws EntityNotFoundException
    {
        return artistService.findByName(name);
    }

    //Exercice 3
    @RequestMapping(value = "")
    public Page<Artist> findAllArtistPaging (@RequestParam("page") Integer page, @RequestParam ("size") Integer size,
                                             @RequestParam("sortDirection") String sortDirection, @RequestParam("sortProperty")
                                                       String sortProperty) throws IllegalArgumentException
    {
        return artistService.findAllArtistPaging(page, size, sortDirection, sortProperty);
    }

    //Exercice 4
    @RequestMapping(value = "", method =RequestMethod.POST, produces ="application/json", consumes = "application/json")
    public Artist nouvelArtist(@RequestBody Artist artist)throws ArtistNameException {
        return artistService.nouvelArtist(artist);
    }

    // Exercice 5
    @RequestMapping(value = "/{id}", method =RequestMethod.PUT)
    public Artist modification (@PathVariable(value ="id") Long id, @RequestBody Artist artist) {
        return artistService.modification(id, artist);

    }

    //Exercice 6
    @RequestMapping(value = "/{id}", method =RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void suppression (@PathVariable(value = "id") Long id){
        artistService.suppression(id);
    }

}
