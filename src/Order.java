import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private int id;
    private User user;
    private List<Product> products;
    private Date orderDate;
    private String status;

    public Order(int id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>(products);
        this.orderDate = new Date();
        this.status = "В обработке";
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = new ArrayList<>(products); }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}