package sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
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
                    displayAllItems;
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

    public static void loadInventory(String FILE_NAME, ArrayList<Product> inventory) {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader buff = new BufferedReader(reader);
            String line;
            while ((line = buff.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2]);
                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found, please enter file name again!" + e.getMessage());


        } catch (IOException e) {
            System.out.println("Error occurred when reading from the file." + e.getMessage());
        }
    }


}