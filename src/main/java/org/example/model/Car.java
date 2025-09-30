package org.example.model;

public class Car {
    // приватні поля
    private int id;
    private String model;
    private int year;
    private double price;
    private String registrationNumber;

    // конструктор
    public Car(int id, String model, int year, double price, String registrationNumber) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // setValue методи
    public void setId(int id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    // getValue методи
    public int getId() { return id; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getRegistrationNumber() { return registrationNumber; }

    // toString
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
