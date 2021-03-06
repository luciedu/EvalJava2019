package com.myaudiolibrary.apirest.controller;
import com.myaudiolibrary.apirest.exception.DoublonException;
import com.myaudiolibrary.apirest.model.Artist;
import com.myaudiolibrary.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController
{

    @Autowired
    private ArtistService artistService;

    //Exercice 1
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Artist trouverArtist(@PathVariable(value = "id") Long id) throws EntityNotFoundException
    {
        return artistService.findById(id);
    }

    //Exercice 2
    @RequestMapping (params = "name") //si dans la requete on a un parametre matricule on ira directement ici
    public List<Artist> artists (@RequestParam(value = "name") String name) throws EntityNotFoundException
    {
        return artistService.findByName(name);
    }


    //Exercice 3
    @RequestMapping()
    public Page<Artist> findAllArtistPaging (@RequestParam("page") Integer page,
                                             @RequestParam ("size") Integer size,
                                             @RequestParam("sortDirection") String sortDirection,
                                             @RequestParam("sortProperty") String sortProperty) throws IllegalArgumentException
    {
        return artistService.findAllArtistPaging(page, size, sortDirection, sortProperty);
    }

    //Exercice 4
    @RequestMapping(value = "", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes =MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Artist nouvelArtist(@RequestBody Artist artist)throws DoublonException {
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
