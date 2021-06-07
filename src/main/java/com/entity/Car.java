package com.entity;

public class Car {
    private String brand;
    private String model;
    private  int year;
    private  String color;
    private  String price;
    private String image;
    public Car(String carBrand, String carModel, int carYear,
               String carColor, String carPrice, String carImage){
        brand = carBrand;
        model = carModel;
        year = carYear;
        color = carColor;
        price = carPrice;
        image = carImage;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
