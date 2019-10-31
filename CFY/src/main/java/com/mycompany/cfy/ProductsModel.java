package com.mycompany.cfy;

import javafx.scene.image.ImageView;

public class ProductsModel {
    
    private String name, size;
    private int price;
    private ImageView image;
    private String path;
    
    public ProductsModel(String name, String size, int price, ImageView image, String path)
    {
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
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
    
    public ImageView getImage() {
        return image;
    }
    
    public void setImage(ImageView image) {
        this.image = image;
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
