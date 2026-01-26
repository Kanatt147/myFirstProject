package model;

public abstract class Employee {
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
        this.active = active;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0)
            throw new IllegalArgumentException("Employee ID must be positive");
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name.trim();
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be negative");
        this.hourlyRate = hourlyRate;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0)
            throw new IllegalArgumentException("Experience years cannot be negative");
        this.experienceYears = experienceYears;
    }

    public abstract void work();
    public abstract String getRole();

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name + " | Rate: " + hourlyRate + " | Exp: " + experienceYears;
    }
}
