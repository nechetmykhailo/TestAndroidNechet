package com.example.mixazp.testandroidnechet.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;


@Root(name = "xml")
public class XML {

    @ElementList(inline = true)
    private ArrayList<Products> myProducts = new ArrayList<>();

    public ArrayList<Products> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(ArrayList<Products> myProducts) {
        this.myProducts = myProducts;
    }

    @Override
    public String toString() {
        return "XML{" +
                "myProducts=" + myProducts +
                '}';
    }
}
//
//
