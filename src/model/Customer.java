package model;

public class Customer {

    private int customerId;
    private String name;
    private int loyaltyPoints;

    public Customer(int customerId, String name, int loyaltyPoints) {
        setCustomerId(customerId);
        setName(name);
        setLoyaltyPoints(loyaltyPoints);
    }

    public void setCustomerId(int customerId) {
        if (customerId <= 0)
            throw new IllegalArgumentException("Customer ID must be positive");
        this.customerId = customerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Customer name cannot be empty");
        this.name = name.trim();
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0)
            throw new IllegalArgumentException("Points cannot be negative");
        this.loyaltyPoints = loyaltyPoints;
    }
}
