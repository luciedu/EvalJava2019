package com.myaudiolibrary.apirest.controller;


import com.myaudiolibrary.apirest.model.Album;
import com.myaudiolibrary.apirest.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController
{

    @Autowired
    private AlbumService albumService;

    // Exercice 7
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Album modification (@PathVariable(value ="id") Long id, @RequestBody Album album) {
        return albumService.modification(id, album);

    }

    //Exercice 8
    @RequestMapping(value = "/{id}", method =RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void suppression (@PathVariable(value = "id") Long id){
        albumService.suppression(id);
    }


}
