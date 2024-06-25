package sales;

public class Product {
    private double price;
    private String type;
    private String title;
    private String fandom;

    public Product(double price, String type, String title, String fandom) {
        this.price = price;
        this.type = type;
        this.title = title;
        this.fandom = fandom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFandom() {
        return fandom;
    }

    public void setFandom(String fandom) {
        this.fandom = fandom;
    }
}
