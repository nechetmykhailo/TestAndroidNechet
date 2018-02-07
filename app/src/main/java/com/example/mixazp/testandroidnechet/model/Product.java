package com.example.mixazp.testandroidnechet.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "product")
public class Product {

    @Element(name = "id")
    private int id;

    @Element(name = "name")
    private String name;

    @Element(name = "price")
    private double price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
