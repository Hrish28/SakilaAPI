package com.tsi.suryavamshi.hrishab.springdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    @Test
    public void testFilmID(){
        Film t1 = new Film();
        t1.setFilmID(2);
        Assertions.assertEquals(t1.getFilmID(),2,"The actor has the current ID");
        t1.setFilmID(4);
        Assertions.assertEquals(t1.getFilmID(),4,"film id match");
    }

    @Test
    public void testFilmTitle(){
        Film t1 = new Film();
        t1.setTitle("Bob");
        Assertions.assertEquals(t1.getTitle(),"Bob","title match");
    }

    @Test
    public void testFilmDesc(){
        Film t1 = new Film();
        t1.setDescription("The legendary story of BOB");
        Assertions.assertEquals(t1.getDescription(),"The legendary story of BOB",
                "the description does not match");
    }

    @Test
    public void testFilmRating(){
        Film t1 = new Film();
        t1.setRating("PG-12");
        Assertions.assertEquals(t1.getRating(),"PG-12","Rating does not match");
    }

    @Test
    public void testFilmYear() {
        Film t1 = new Film();
        t1.setYear(2004);
        Assertions.assertEquals(t1.getYear(), 2004, "Year does not match");
    }

    @Test
    public void testFilmLangID() {
        Film t1 = new Film();
        t1.setLanguage(3);
        Assertions.assertEquals(t1.getLanguage(), 3, "Language does not match");
    }



}
