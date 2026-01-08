public class Order {
    private int orderId;
    private int customerId;
    private int itemId;
    private int quantity;
    private double totalCost;
    private String status;

    public Order(int orderId, int customerId, int itemId, int quantity, double totalCost, String status) {
        setOrderId(orderId);
        setCustomerId(customerId);
        setItemId(itemId);
        setQuantity(quantity);
        setTotalCost(totalCost);
        setStatus(status);
    }

    public Order() {
        this.orderId = 0;
        this.customerId = 0;
        this.itemId = 0;
        this.quantity = 1;
        this.totalCost = 0.0;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public int getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public double getTotalCost() { return totalCost; }
    public String getStatus() { return status; }

    public void setOrderId(int orderId) {
        if (orderId > 0) this.orderId = orderId;
        else {
            System.out.println("Warning: Order ID must be positive! Setting to 0.");
            this.orderId = 0;
        }
    }

    public void setCustomerId(int customerId) {
        if (customerId > 0) this.customerId = customerId;
        else {
            System.out.println("Warning: Customer ID must be positive! Setting to 0.");
            this.customerId = 0;
        }
    }

    public void setItemId(int itemId) {
        if (itemId > 0) this.itemId = itemId;
        else {
            System.out.println("Warning: Item ID must be positive! Setting to 0.");
            this.itemId = 0;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) this.quantity = quantity;
        else {
            System.out.println("Warning: Quantity must be positive! Setting to 1.");
            this.quantity = 1;
        }
    }

    public void setTotalCost(double totalCost) {
        if (totalCost >= 0) this.totalCost = totalCost;
        else {
            System.out.println("Warning: Total cost cannot be negative! Setting to 0.");
            this.totalCost = 0.0;
        }
    }

    public void setStatus(String status) {
        if (status == null) {
            this.status = "Pending";
            return;
        }
        String s = status.trim();
        if (s.equalsIgnoreCase("Pending") ||
                s.equalsIgnoreCase("Completed") ||
                s.equalsIgnoreCase("Cancelled")) {
            this.status = capitalize(s);
        } else {
            System.out.println("Warning: Invalid status! Using Pending.");
            this.status = "Pending";
        }
    }

    private String capitalize(String s) {
        if (s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public boolean isPending() {
        return status != null && status.equalsIgnoreCase("Pending");
    }

    public void calculateTotal(double itemPrice) {
        if (itemPrice < 0) itemPrice = 0;
        this.totalCost = itemPrice * this.quantity;
    }

    public void complete() {
        if (isPending()) this.status = "Completed";
    }

    public void cancel() {
        if (isPending()) this.status = "Cancelled";
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId +
                ", customerId=" + customerId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", totalCost=" + String.format("%.2f", totalCost) +
                ", status='" + status + '\'' +
                '}';
    }
}
