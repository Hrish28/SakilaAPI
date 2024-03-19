package com.tsi.suryavamshi.hrishab.springdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;



public class ActorTest {

    @Test
    public void testActorID(){
        Actor t1 = new Actor();
        t1.setActorID(2);
        Assertions.assertEquals(t1.getActorID(),2,"The actor has the current ID");
        t1.setActorID(4);
        Assertions.assertEquals(t1.getActorID(),4,"the actor id has now been changed");
    }

    @Test
    public void testActorFName(){
        Actor t1 = new Actor();
        t1.setFirstName("Bob");
        Assertions.assertEquals(t1.getFirstName(),"Bob","The actor the first name bob");
    }

    @Test
    public void testActorLName(){
        Actor t1 = new Actor();
        t1.setLastName("Marley");
        Assertions.assertEquals(t1.getLastName(),"Marley","The actor the first name bob");
    }



    }




