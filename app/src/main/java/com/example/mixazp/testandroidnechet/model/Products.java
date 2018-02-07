package com.example.mixazp.testandroidnechet.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "products", strict = false)
public class Products {

    @ElementList(inline = true)
    private ArrayList<Product> myProducts;

    public ArrayList<Product> getProducts() {
        return myProducts;
    }

    public void setProducts(ArrayList<Product> products) {
        this.myProducts = products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + myProducts +
                '}';
    }
}