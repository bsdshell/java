package com.company;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by cat on 2/29/16.
 */
public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void test1(){
        String str = "abc";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("abc"));
    }

    @Test
    public void test2(){
        String str = " abc ";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("abc"));
    }

    @Test
    public void test3(){
        String str = " abc";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("abc"));
    }

    @Test
    public void test4(){
        String str = "abc ";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("abc"));
    }

    @Test
    public void test5(){
        String str = "a bc ";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("a"));
        Assert.assertTrue(list.get(1).equals("bc"));
    }

    @Test
    public void test6(){
        String str = "a bc";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("a"));
        Assert.assertTrue(list.get(1).equals("bc"));
    }

    @Test
    public void test7(){
        String str = " a bc";
        List<String> list = Main.splitString(str);
        Assert.assertTrue(list.get(0).equals("a"));
        Assert.assertTrue(list.get(1).equals("bc"));
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }
}