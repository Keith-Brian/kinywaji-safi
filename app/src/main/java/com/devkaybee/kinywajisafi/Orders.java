package com.devkaybee.kinywajisafi;

public class Orders {

    String branch, brand, size, price;

    public Orders(){

    }

    public Orders(String branch, String brand, String size, String price) {
        this.branch = branch;
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
