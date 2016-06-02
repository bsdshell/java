package com.company;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item{
    String name;
    double price;
}

class VendorMachine {
    Map<String, List<Item>> map = new HashMap<String, List<Item>>();
    double total;
    double currentCash;
    public VendorMachine(){
    }


    public void displayMessage(){

    }

    public Pair<Item, Double> buy(Double cash, Item item) {
                
    }
}




public class Main {

    public static void main(String[] args) {
        // write your code here

        // input cash
        // addCash(cash)
        // keyItem(String key)
        // if(isEnoughCash() && item != null)
        //      buy(cash, item)


    }
}
