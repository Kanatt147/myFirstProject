public class Order {
    private int orderId;
    private int customerId;
    private int itemId;
    private int quantity;
    private double totalCost;
    private String status;

    public Order(int orderId, int customerId, int itemId, int quantity, double totalCost, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.status = status;
    }

    public Order() {
        this.orderId = 0;
        this.customerId = 0;
        this.itemId = 0;
        this.quantity = 0;
        this.totalCost = 0.0;
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPending() {
        if (this.status == null) {
            return false;
        }
        return this.status.equalsIgnoreCase("Pending");
    }

    public void calculateTotal(double itemPrice) {
        if (itemPrice < 0) {
            itemPrice = 0;
        }
        if (this.quantity < 0) {
            this.quantity = 0;
        }
        this.totalCost = itemPrice * this.quantity;
    }

    public void complete() {
        if (isPending()) {
            this.status = "Completed";
        }
    }

    public void cancel() {
        if (isPending()) {
            this.status = "Cancelled";
        }
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", customerId=" + customerId + ", itemId=" + itemId + ", quantity=" + quantity + ", totalCost=" + totalCost + ", status='" + status + "'}";
    }
}
