package com.company;
import junit.framework.Assert;
import static com.company.Main.removeDuplicateStr;

public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }
    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testRemoveDuplicateStr() throws Exception {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer buffer = removeDuplicateStr(sb);
        for(int i=0; i<buffer.length(); i++){
            System.out.println("item=" + buffer.charAt(i));
        }
        Assert.assertTrue(buffer.charAt(0) == 'a');
        Assert.assertTrue(buffer.charAt(1) == 'b');
        Assert.assertTrue(buffer.charAt(2) == 'c');
    }

    @org.junit.Test
    public void testRemoveDuplicateStr1() throws Exception {
            StringBuffer sb = new StringBuffer("ab");
            StringBuffer buffer = removeDuplicateStr(sb);
        Assert.assertTrue(buffer.charAt(0) == 'a');
        Assert.assertTrue(buffer.charAt(1) == 'b');
    }

    @org.junit.Test
    public void testRemoveDuplicateStr2() throws Exception {
        StringBuffer sb = new StringBuffer("aaa");
        StringBuffer buffer = removeDuplicateStr(sb);
        for(int i=0; i<buffer.length(); i++){
            System.out.println("item=" + buffer.charAt(i));
        }
        Assert.assertTrue(buffer.charAt(0) == 'a');
    }

    @org.junit.Test
    public void testRemoveDuplicateStr3() throws Exception {
        StringBuffer sb = new StringBuffer("aaabb");
        StringBuffer buffer = removeDuplicateStr(sb);
        for(int i=0; i<buffer.length(); i++){
            System.out.println("item=" + buffer.charAt(i));
        }
        Assert.assertTrue(buffer.charAt(0) == 'a');
        Assert.assertTrue(buffer.charAt(1) == 'b');
    }

    @org.junit.Test
    public void testRemoveDuplicateStr5() throws Exception {
        StringBuffer sb = new StringBuffer("ab");
        StringBuffer buffer = removeDuplicateStr(sb);
        for(int i=0; i<buffer.length(); i++){
            System.out.println("item=" + buffer.charAt(i));
        }
        Assert.assertTrue(buffer.charAt(0) == 'a');
        Assert.assertTrue(buffer.charAt(1) == 'b');
    }

}