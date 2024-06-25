package sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "products.csv";
    private static final ArrayList<Product> inventory = new ArrayList<Product>();
    private static final ArrayList<Product> cart = new ArrayList<Product>();
    private static final Scanner myScanner = new Scanner(System.in);

    private static boolean running = true;

    public static void main(String[] args) {

        double totalAmount = 0.0;
        loadInventory(FILE_NAME, inventory);

        while (running) {
            System.out.println("Hello Sam !");
            System.out.println("Welcome to your Merchandise Inventory!");
            System.out.println("1. Show Products");
            System.out.println("2. Add Products");
            System.out.println("3. Remove Products");
            System.out.println("4. Exit");
            String response = myScanner.nextLine();
            switch (response) {
                case "1":
                    displayAllInventory();
                    break;
                case "2":
                    addNewItem;
                    break;
                case "3":
                    removeItem;
                    break;
                case "4":
                    System.out.println("Leaving application...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        myScanner.close();
    }

    public static void displayAllInventory() {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader buff = new BufferedReader(reader);
            String line;
            while ((line = buff.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    double price = Double.parseDouble(parts[0]);
                    String type = parts[1].trim();
                    String title = parts[2].trim();
                    String fandom = parts[3].trim();
                    Product product = new Product(price, type, title, fandom);
                    inventory.add(product);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, please enter file name again!" + e.getMessage());


        } catch (IOException e) {
            System.out.println("Error occurred when reading from the file." + e.getMessage());
        }

//        public void addNewItem() {
//
//        }
//
//        public void removeItem() {
//
//        }
    }


}