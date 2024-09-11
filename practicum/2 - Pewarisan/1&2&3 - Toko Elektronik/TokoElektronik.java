// 18222082
// 24-03-04

import java.util.Scanner;

public class TokoElektronik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totprice = 0;
        for(int i = 0; i < n; i ++) {
            int type = scanner.nextInt();
            if(type == 1) {
                String brand = scanner.next();
                String model = scanner.next();
                int storageCapacity = scanner.nextInt();
                int batteryLife = scanner.nextInt();

                Smartphone smartphone = new Smartphone(brand, model, storageCapacity, batteryLife);

                int price = smartphone.calculatePrice();
                totprice += price;

                smartphone.displayDetails();
                System.out.println("Price: " + price);
            }
            else if(type == 2) {
                String brand = scanner.next();
                String model = scanner.next();
                String processorType = scanner.next();
                int ram = scanner.nextInt();
                boolean isTouchScreen = (scanner.nextInt() == 1 ? true : false);

                Laptop laptop = new Laptop(brand, model, processorType, ram, isTouchScreen);

                int price = laptop.calculatePrice();
                totprice += price;

                laptop.displayDetails();
                System.out.println("Price: " + price);
            }
            else {
                String brand = scanner.next();
                String model = scanner.next();
                int screenSize = scanner.nextInt();
                boolean hasCellular = (scanner.nextInt() == 1 ? true : false);

                Tablet tablet = new Tablet(brand, model, screenSize, hasCellular);

                int price = tablet.calculatePrice();
                totprice += price;

                tablet.displayDetails();
                System.out.println("Price: " + price);
            }
        }
        System.out.println("Total price: " + totprice);
        scanner.close();
    }
}
