package com.tsi.suryavamshi.hrishab.springdemo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="language")
public class Language {
    @Id
    @Column(name="language_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int langID;

    @Column(name = "name")
    private String name;

//    public int getLangID() {
//        return langID;
//    }

    public void setLangID(int langID) {
        this.langID = langID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilmSet() {
        return filmSet;
    }

    public void setFilmSet(Set<Film> filmSet) {
        this.filmSet = filmSet;
    }

    @OneToMany(mappedBy="languageString")
    private Set<Film> filmSet;

}
