package com.company.hw02;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDemo {
    @Test
    public void testHW(){
        List<Id> black = new ArrayList<>();
        List<Id> white = new ArrayList<>();
        Collections.addAll(black,new Id("2","H"),new Id("3","D"),new Id("5","S"),
                new Id("9","C"),new Id("K","D"));
        Collections.addAll(white,new Id("2","C"),new Id("3","H"),new Id("4","S"),
                new Id("8","C"),new Id("A","H"));
        Assert.assertEquals(Demo.of(black,white),"white wins");
    }
}
