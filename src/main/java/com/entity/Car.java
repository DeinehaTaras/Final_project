package com.entity;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String price;
    private String image;
    private String comfortClass;
    private String status;

    public Car(String carBrand, String carModel, int carYear,
               String carColor, String carPrice, String carImage,
               String carClass, String carStatus) {
        brand = carBrand;
        model = carModel;
        year = carYear;
        color = carColor;
        price = carPrice;
        image = carImage;
        comfortClass = carClass;
        status = carStatus;
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

    public String getComfortClass() {
        return comfortClass;
    }

    public String getStatus() {
        return status;
    }
}
