package com.myaudiolibrary.apirest.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name="artist")

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @OneToMany (mappedBy = "artist")
    @JsonManagedReference // eviter pb de recurcivité
    private List<Album> albums;

    @Column(name="ArtitsId")
    private Long id;

    @Column(name="Name")
    private String Name;

    //Constructeur
    public Artist(List<Album> albums, Long id, String name) {
        this.albums = albums;
        this.id = id;
        Name = name;
    }

    //Getters & Setters
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(albums, artist.albums) &&
                Objects.equals(id, artist.id) &&
                Objects.equals(Name, artist.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albums, id, Name);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "albums=" + albums +
                ", id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
