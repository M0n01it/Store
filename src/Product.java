public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private int rating;

    public Product(int id, String name, String manufacturer, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.rating = 0;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}