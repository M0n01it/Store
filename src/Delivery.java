public class Delivery {
    private int orderId;
    private String deliveryStatus;

    public Delivery(int orderId) {
        this.orderId = orderId;
        this.deliveryStatus = "На складе";
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    public void updateStatus(String status) {
        this.deliveryStatus = status;
    }
}