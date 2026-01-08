public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private int loyaltyPoints;
    private boolean vip;

    public Customer(int customerId, String name, String phoneNumber, String email, int loyaltyPoints, boolean vip) {
        setCustomerId(customerId);
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setLoyaltyPoints(loyaltyPoints);
        this.vip = this.loyaltyPoints >= 200;
    }

    public Customer() {
        this.customerId = 0;
        this.name = "Unknown";
        this.phoneNumber = "N/A";
        this.email = "N/A";
        this.loyaltyPoints = 0;
        this.vip = false;
    }

    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public boolean isVip() { return vip; }

    public void setCustomerId(int customerId) {
        if (customerId > 0) {
            this.customerId = customerId;
        } else {
            System.out.println("Warning: Customer ID must be positive! Setting to 0.");
            this.customerId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Warning: Customer name cannot be empty!");
            if (this.name == null) this.name = "Unknown";
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber.trim();
        } else {
            System.out.println("Warning: Phone number cannot be empty! Setting to N/A.");
            this.phoneNumber = "N/A";
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email.trim();
        } else {
            System.out.println("Warning: Invalid email! Must contain '@'. Setting to N/A.");
            this.email = "N/A";
        }
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Warning: Loyalty points cannot be negative! Setting to 0.");
            this.loyaltyPoints = 0;
        }
        this.vip = this.loyaltyPoints >= 200;
    }

    public void setVip(boolean vip) {
        this.vip = this.loyaltyPoints >= 200;
    }

    public void addPoints(int points) {
        if (points <= 0) {
            System.out.println("Warning: Points to add must be positive!");
            return;
        }
        this.loyaltyPoints += points;
        this.vip = this.loyaltyPoints >= 200;
    }

    public boolean redeemPoints(int points) {
        if (points <= 0) return false;
        if (this.loyaltyPoints < points) return false;

        this.loyaltyPoints -= points;
        this.vip = this.loyaltyPoints >= 200;
        return true;
    }

    public String getContactCard() {
        return this.name + " | " + this.phoneNumber + " | " + this.email;
    }

    @Override
    public String toString() {
        return "Customer{customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", vip=" + vip +
                '}';
    }
}
