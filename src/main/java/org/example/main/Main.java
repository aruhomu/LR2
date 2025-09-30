package org.example.main;

import org.example.model.Car;
import java.util.Scanner;

public class Main {

    public static Car[] createCarsArray(int size, Scanner scanner) {
        Car[] cars = new Car[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\n\nCar №" + (i + 1));

            int id;
            String model;
            int year;
            double price;
            String regNumber;

            // 1. ID
            do {
                System.out.print("ID: ");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.print("ID: ");
                }
                id = scanner.nextInt();
            } while (id < 0);
            scanner.nextLine(); // очистка буфера

            // 2. Model
            System.out.print("Model: ");
            model = scanner.nextLine();

            // 3. Year
            do {
                System.out.print("Year: ");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.print("Year: ");
                }
                year = scanner.nextInt();
            } while (year < 1886 || year > java.time.Year.now().getValue());
            scanner.nextLine(); // очистка буфера

            // 4. Price
            do {
                System.out.print("Price: ");
                while (!scanner.hasNextDouble()) {
                    scanner.next();
                    System.out.print("Price: ");
                }
                price = scanner.nextDouble();
            } while (price < 0);
            scanner.nextLine(); // очистка буфера

            // 5. Registration Number
            System.out.print("Registration Number: ");
            regNumber = scanner.nextLine();

            // створюємо об’єкт
            cars[i] = new Car(id, model, year, price, regNumber);
        }

        return cars;
    }

    public static void printCarsByModel(Car[] cars, String model) {
        System.out.println("\nCars with model '" + model + "':");
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByModelAndAge(Car[] cars, String model, int n) {
        System.out.println("\nCars with model '" + model + "' older than " + n + " years:");
        int currentYear = java.time.Year.now().getValue();
        for (Car car : cars) {
            int age = currentYear - car.getYear();
            if (car.getModel().equalsIgnoreCase(model) && age > n) {
                System.out.println(car);
            }
        }
    }

    public static void printCarsByYearAndPrice(Car[] cars, int year, double price) {
        System.out.println("\nCars from year " + year + " with price greater than " + price + ":");
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                System.out.println(car);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості автомобілів
        int carCount;
        do {
            System.out.print("Enter number of cars: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Enter number of cars: ");
            }
            carCount = scanner.nextInt();
        } while (carCount < 1);
        scanner.nextLine();

        Car[] cars = createCarsArray(carCount, scanner);

        // Введення критеріїв для фільтрації
        System.out.print("\nEnter model to filter: ");
        String modelFilter = scanner.nextLine();

        System.out.print("Enter model to filter by age: ");
        String modelByAge = scanner.nextLine();

        System.out.print("Enter minimum age (years): ");
        int minAge;
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Enter minimum age (years): ");
        }
        minAge = scanner.nextInt();

        System.out.print("Enter year to filter by price: ");
        int yearFilter;
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Enter year to filter by price: ");
        }
        yearFilter = scanner.nextInt();

        System.out.print("Enter minimum price: ");
        double minPrice;
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Enter minimum price: ");
        }
        minPrice = scanner.nextDouble();

        printCarsByModel(cars, modelFilter);
        printCarsByModelAndAge(cars, modelByAge, minAge);
        printCarsByYearAndPrice(cars, yearFilter, minPrice);

        scanner.close();
    }
}