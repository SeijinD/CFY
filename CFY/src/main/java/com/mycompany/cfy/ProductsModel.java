package com.mycompany.cfy;

public class ProductsModel {
    
    private String name, size;
    private int price;
    
    public ProductsModel(String name, String size, int price)
    {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
       
}
