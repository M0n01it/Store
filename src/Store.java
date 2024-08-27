import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private List<Product> products;
    private List<User> users;
    private List<Order> orders;
    private List<Delivery> deliveries;
    private List<Rating> ratings;

    public Store() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.deliveries = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    // Adding products
    public void addProduct(Product product) {
        products.add(product);
    }

    // Adding users
    public void addUser(User user) {
        users.add(user);
    }

    // Getting list of users
    public List<User> getUsers() {
        return users;
    }

    // Listing all products
    public List<Product> getProducts() {
        return products;
    }

    // Filtering products
    public List<Product> filterProducts(double minPrice, double maxPrice, String keyword) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .filter(p -> p.getName().contains(keyword) || p.getManufacturer().contains(keyword))
                .collect(Collectors.toList());
    }

    // Placing an order
    public Order placeOrder(User user) {
        Order order = new Order(orders.size() + 1, user, user.getCart().getProducts());
        orders.add(order);
        deliveries.add(new Delivery(order.getId()));
        user.getCart().getProducts().clear();
        return order;
    }

    // Tracking delivery
    public Delivery trackDelivery(int orderId) {
        return deliveries.stream().filter(d -> d.getOrderId() == orderId).findFirst().orElse(null);
    }

    // Rating a product
    public void rateProduct(int userId, int productId, int ratingValue) {
        ratings.add(new Rating(productId, userId, ratingValue));
        // Update product rating (Example of using magic numbers is avoided in rating calculations)
        int totalRating = (int) ratings.stream().filter(r -> r.getProductId() == productId).mapToInt(Rating::getRating).sum();
        long count = ratings.stream().filter(r -> r.getProductId() == productId).count();
        if (count > 0) {
            products.stream().filter(p -> p.getId() == productId).findFirst().ifPresent(p -> p.setRating(totalRating / (int) count));
        }
    }

    // Simple recommendation system based on ratings
    public List<Product> getRecommendations() {
        return products.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getRating(), p1.getRating()))
                .limit(5)
                .collect(Collectors.toList());
    }

    // Adding more optional methods as needed here...
}