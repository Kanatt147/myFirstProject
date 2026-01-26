package model;

public class ClothingItem {
    private int itemId;
    private String name;
    private double price;
    private int stock;

    public ClothingItem(int id, String name, double price, int stock) {
        setItemId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public void setItemId(int itemId) {
        if (itemId <= 0)
            throw new IllegalArgumentException("Item ID must be positive");
        this.itemId = itemId;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Item name cannot be empty");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setStock(int stock) {
        if (stock < 0)
            throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }
}
