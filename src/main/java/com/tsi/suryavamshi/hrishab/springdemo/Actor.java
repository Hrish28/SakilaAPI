package com.tsi.suryavamshi.hrishab.springdemo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")

public class Actor {
    @Id
    @Column(name="actor_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "film_actor",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "film_id") }
    )
    Set<PartFilms> films = new HashSet<>();

    public int getActorID() {
        return actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<PartFilms> getFilms(){ return films;}
    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
