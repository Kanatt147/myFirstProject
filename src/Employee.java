public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double hourlyRate;
    private int salesMade;
    private boolean active;

    public Employee(int employeeId, String name, String position, double hourlyRate, int salesMade, boolean active) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.salesMade = salesMade;
        this.active = active;
    }

    public Employee() {
        this.employeeId = 0;
        this.name = "Unknown";
        this.position = "Sales";
        this.hourlyRate = 0.0;
        this.salesMade = 0;
        this.active = true;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getSalesMade() {
        return salesMade;
    }

    public boolean isActive() {
        return active;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setSalesMade(int salesMade) {
        this.salesMade = salesMade;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void recordSale() {
        if (!this.active) {
            return;
        }
        this.salesMade = this.salesMade + 1;
    }

    public boolean isTopSeller() {
        return this.salesMade >= 10;
    }

    public double calculateWeeklyPay(int hoursWorked) {
        if (!this.active) {
            return 0.0;
        }
        if (hoursWorked < 0) {
            hoursWorked = 0;
        }
        return this.hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "Employee{employeeId=" + employeeId + ", name='" + name + "', position='" + position + "', hourlyRate=" + hourlyRate + ", salesMade=" + salesMade + ", active=" + active + "}";
    }
}
