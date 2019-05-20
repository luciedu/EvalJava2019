package com.myaudiolibrary.apirest.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity //pour mapper sur une BDD
@Table (name="artist") //recupère le nom dans la BDD

public class Artist

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ArtistId") //récupérer les noms des colonnes de la BDD
    private Long id;
    @Column(name="Name") //récupérer les noms des colonnes de la BDD
    private String name;

    @OneToMany (mappedBy = "artist")
    @JsonManagedReference // éviter le problème de recurcivité
    private List<Album> albums;


//Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

//Constructeur
    public Artist() {
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albums=" + albums +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(name, artist.name) &&
                Objects.equals(albums, artist.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, albums);
    }
}
