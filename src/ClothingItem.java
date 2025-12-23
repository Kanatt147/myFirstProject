public class ClothingItem {
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;
    private int stock;

    public ClothingItem(int itemId, String name, String size, double price, String brand, int stock) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
    }

    public ClothingItem() {
        this.itemId = 0;
        this.name = "Unknown";
        this.size = "M";
        this.price = 0.0;
        this.brand = "Generic";
        this.stock = 0;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getStock() {
        return stock;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isInStock() {
        return this.stock > 0;
    }

    public boolean sellOne() {
        if (this.stock <= 0) {
            return false;
        }
        this.stock = this.stock - 1;
        return true;
    }

    public void restock(int amount) {
        if (amount <= 0) {
            return;
        }
        this.stock = this.stock + amount;
    }

    public void applyDiscount(double percent) {
        if (percent <= 0) {
            return;
        }
        if (percent > 80) {
            percent = 80;
        }
        this.price = this.price * (1 - percent / 100.0);
    }

    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemId + ", name='" + name + "', size='" + size + "', price=" + price + ", brand='" + brand + "', stock=" + stock + "}";
    }
}
