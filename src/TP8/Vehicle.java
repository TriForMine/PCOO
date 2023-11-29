package TP8;

public abstract class Vehicle implements Info {
    protected String model;
    protected String brand;
    protected String color;
    protected int year;

    protected Vehicle(String model, String brand, String color, int year) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public void getSummary() {
        this.showMessage("Model: " + this.model);
        this.showMessage("Brand: " + this.brand);
        this.showMessage("Color: " + this.color);
        this.showMessage("Year: " + this.year);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
