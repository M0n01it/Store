import java.util.ArrayList;
import java.util.List;

public class Cart {
    private User user;
    private List<Product> products;

    public Cart(User user) {
        this.user = user;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}