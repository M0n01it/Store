import java.util.Scanner;

public class Main {
    private static Store store;

    public static void main(String[] args) {
        store = new Store();
        loadSampleData();
        run();
    }

    private static void loadSampleData() {
        store.addProduct(new Product(1, "Smartphone", "Brand A", 500));
        store.addProduct(new Product(2, "Laptop", "Brand B", 1500));
        store.addProduct(new Product(3, "Smart TV", "Brand C", 800));

        User user = new User(1, "John Doe");
        store.addUser(user);
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        User currentUser = store.getUsers().get(0); // Simplified for example

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Filter Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Track Order");
            System.out.println("7. Rate Product");
            System.out.println("8. Recommendations");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    filterProducts(scanner);
                    break;
                case 3:
                    addToCart(scanner, currentUser);
                    break;
                case 4:
                    viewCart(currentUser);
                    break;
                case 5:
                    placeOrder(currentUser);
                    break;
                case 6:
                    trackOrder(scanner);
                    break;
                case 7:
                    rateProduct(scanner, currentUser);
                    break;
                case 8:
                    viewRecommendations();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void viewProducts() {
        for (Product product : store.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - " + product.getRating() + " stars");
        }
    }

    private static void filterProducts(Scanner scanner) {
        System.out.println("Enter min price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter max price:");
        double maxPrice = scanner.nextDouble();
        System.out.println("Enter keyword:");
        scanner.nextLine(); // Consume newline
        String keyword = scanner.nextLine();
        for (Product product : store.filterProducts(minPrice, maxPrice, keyword)) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - " + product.getRating() + " stars");
        }
    }

    private static void addToCart(Scanner scanner, User user) {
        System.out.println("Enter product ID:");
        int productId = scanner.nextInt();
        Product product = store.getProducts().stream().filter(p -> p.getId() == productId).findFirst().orElse(null);
        if (product != null) {
            user.getCart().addProduct(product);
            System.out.println("Added to cart");
        } else {
            System.out.println("Product not found");
        }
    }

    private static void viewCart(User user) {
        for (Product product : user.getCart().getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("Total: " + user.getCart().getTotalPrice());
    }

    private static void placeOrder(User user) {
        Order order = store.placeOrder(user);
        System.out.println("Order placed with ID: " + order.getId());
    }

    private static void trackOrder(Scanner scanner) {
        System.out.println("Enter order ID:");
        int orderId = scanner.nextInt();
        Delivery delivery = store.trackDelivery(orderId);
        if (delivery != null) {
            System.out.println("Order status: " + delivery.getDeliveryStatus());
        } else {
            System.out.println("Order not found");
        }
    }

    private static void rateProduct(Scanner scanner, User user) {
        System.out.println("Enter product ID:");
        int productId = scanner.nextInt();
        System.out.println("Enter rating (1-5):");
        int rating = scanner.nextInt();
        store.rateProduct(user.getId(), productId, rating);
        System.out.println("Rating submitted");
    }

    private static void viewRecommendations() {
        for (Product product : store.getRecommendations()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " - " + product.getRating() + " stars");
        }
    }
}