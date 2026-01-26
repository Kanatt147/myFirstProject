package model;

public class SalesAssistant extends Employee implements Sellable {
    private int itemsSold;

    public SalesAssistant(int id, String name, double rate, int exp, boolean active, int itemsSold) {
        super(id, name, rate, exp, active);
        setItemsSold(itemsSold);
    }

    public void setItemsSold(int itemsSold) {
        if (itemsSold < 0)
            throw new IllegalArgumentException("Items sold cannot be negative");
        this.itemsSold = itemsSold;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    @Override
    public void sell(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");
        itemsSold += amount;
    }

    @Override
    public void work() {
        System.out.println("Sales Assistant " + name + " is helping customers.");
    }

    @Override
    public String getRole() {
        return "SalesAssistant";
    }

    public boolean isTopSeller() {
        return itemsSold >= 100 && experienceYears >= 3;
    }
}
