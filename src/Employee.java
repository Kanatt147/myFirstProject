public class Employee {
    protected int employeeId;
    protected String name;
    protected double hourlyRate;
    protected int experienceYears;
    protected boolean active;

    public Employee(int employeeId, String name, double hourlyRate, int experienceYears, boolean active) {
        setEmployeeId(employeeId);
        setName(name);
        setHourlyRate(hourlyRate);
        setExperienceYears(experienceYears);
        setActive(active);
    }

    public Employee() {
        this.employeeId = 0;
        this.name = "Unknown";
        this.hourlyRate = 0.0;
        this.experienceYears = 0;
        this.active = true;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getHourlyRate() { return hourlyRate; }
    public int getExperienceYears() { return experienceYears; }
    public boolean isActive() { return active; }

    public void setEmployeeId(int employeeId) {
        if (employeeId > 0) this.employeeId = employeeId;
        else {
            System.out.println("Warning: Employee ID must be positive! Setting to 0.");
            this.employeeId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else {
            System.out.println("Warning: Employee name cannot be empty!");
            if (this.name == null) this.name = "Unknown";
        }
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) this.hourlyRate = hourlyRate;
        else {
            System.out.println("Warning: Hourly rate cannot be negative! Setting to 0.");
            this.hourlyRate = 0.0;
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) this.experienceYears = experienceYears;
        else {
            System.out.println("Warning: Experience years cannot be negative! Setting to 0.");
            this.experienceYears = 0;
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void work() {
        System.out.println(name + " is working in the store.");
    }

    public String getRole() {
        return "Employee";
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public double calculateWeeklyPay(int hoursWorked) {
        if (!active) return 0.0;
        if (hoursWorked < 0) hoursWorked = 0;
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " (ID: " + employeeId +
                ", Rate: " + String.format("%.2f", hourlyRate) + " KZT/hr" +
                ", Exp: " + experienceYears + " yrs" +
                ", Active: " + active + ")";
    }
}
