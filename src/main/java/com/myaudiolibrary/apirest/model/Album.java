package com.myaudiolibrary.apirest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="album")


public class Album {

    @ManyToOne
    @JoinColumn (name="ArtistId")
    private Artist artist;

    @Column(name="AlbumId")
    private Long id;

    @Column(name="Title")
    private String Title;


    //Constructeur
    public Album(){
    }

    public Album(Artist artist, Long id, String title) {
        this.artist = artist;
        this.id = id;
        Title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    //Getters & Setters
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(artist, album.artist) &&
                Objects.equals(id, album.id) &&
                Objects.equals(Title, album.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, id, Title);
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist=" + artist +
                ", id=" + id +
                ", Title='" + Title + '\'' +
                '}';
    }
}
