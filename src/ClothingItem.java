public class ClothingItem {
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;
    private int stock;

    public ClothingItem(int itemId, String name, String size, double price, String brand, int stock) {
        setItemId(itemId);
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
        setStock(stock);
    }

    public ClothingItem() {
        this.itemId = 0;
        this.name = "Unknown";
        this.size = "M";
        this.price = 0.0;
        this.brand = "Generic";
        this.stock = 0;
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public int getStock() { return stock; }

    public void setItemId(int itemId) {
        if (itemId > 0) {
            this.itemId = itemId;
        } else {
            System.out.println("Warning: Item ID must be positive! Setting to 0.");
            this.itemId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Warning: Item name cannot be empty! Keeping previous value.");
            if (this.name == null) this.name = "Unknown";
        }
    }

    public void setSize(String size) {
        if (size == null) {
            System.out.println("Warning: Size cannot be null! Setting to M.");
            this.size = "M";
            return;
        }
        String s = size.trim().toUpperCase();
        if (s.equals("S") || s.equals("M") || s.equals("L") || s.equals("XL") || s.equals("XXL")) {
            this.size = s;
        } else {
            System.out.println("Warning: Invalid size! Allowed: S/M/L/XL/XXL. Setting to M.");
            this.size = "M";
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price cannot be negative! Setting to 0.");
            this.price = 0.0;
        }
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand.trim();
        } else {
            System.out.println("Warning: Brand cannot be empty! Keeping previous value.");
            if (this.brand == null) this.brand = "Generic";
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Warning: Stock cannot be negative! Setting to 0.");
            this.stock = 0;
        }
    }

    public boolean isInStock() {
        return this.stock > 0;
    }

    public boolean sellOne() {
        if (this.stock <= 0) return false;
        this.stock--;
        return true;
    }

    public void restock(int amount) {
        if (amount <= 0) {
            System.out.println("Warning: Restock amount must be positive!");
            return;
        }
        this.stock += amount;
    }

    public void applyDiscount(double percent) {
        if (percent <= 0 || percent > 80) {
            System.out.println("Warning: Discount must be between 1 and 80.");
            return;
        }
        this.price = this.price * (1 - percent / 100.0);
    }

    public String getFormattedPrice() {
        return String.format("%.2f KZT", price);
    }

    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + String.format("%.2f", price) +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                '}';
    }
}
