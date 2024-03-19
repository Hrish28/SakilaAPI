package com.tsi.suryavamshi.hrishab.springdemo;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="film_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private String rating;

    @Column(name = "release_year")
    private int year;

    @Column(name = "language_id")
    private int language;
    @ManyToOne
    @JoinColumn(name="language_id", nullable=false,insertable=false, updatable=false)
    private PartLanguage languageString;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "film_actor",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    private Set<PartActor> actors = new HashSet<>();

    public PartLanguage getLanguageString() {
        return languageString;
    }

    public void setLanguageString(PartLanguage languageString) {
        this.languageString = languageString;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public  Set<PartActor> getActors(){return actors;}
    public void setYear(int year) {
        this.year = year;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}


