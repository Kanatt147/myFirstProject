public class SalesAssistant extends Employee {
    private int itemsSold;

    public SalesAssistant(int employeeId, String name, double hourlyRate, int experienceYears, boolean active, int itemsSold) {
        super(employeeId, name, hourlyRate, experienceYears, active);
        setItemsSold(itemsSold);
    }

    public int getItemsSold() { return itemsSold; }

    public void setItemsSold(int itemsSold) {
        if (itemsSold >= 0) this.itemsSold = itemsSold;
        else {
            System.out.println("Warning: Items sold cannot be negative! Setting to 0.");
            this.itemsSold = 0;
        }
    }

    @Override
    public void work() {
        System.out.println("Sales Assistant " + name + " is helping customers choose clothing.");
    }

    @Override
    public String getRole() {
        return "SalesAssistant";
    }

    public void recordSale(int items) {
        if (!active) return;
        if (items <= 0) return;
        itemsSold += items;
    }

    public boolean isTopSeller() {
        return itemsSold >= 100 && experienceYears >= 3;
    }

    @Override
    public String toString() {
        return super.toString() + " | Items Sold: " + itemsSold;
    }
}
