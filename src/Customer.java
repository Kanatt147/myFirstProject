public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private int loyaltyPoints;
    private boolean vip;

    public Customer(int customerId, String name, String phoneNumber, String email, int loyaltyPoints, boolean vip) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.vip = vip;
    }

    public Customer() {
        this.customerId = 0;
        this.name = "Unknown";
        this.phoneNumber = "N/A";
        this.email = "N/A";
        this.loyaltyPoints = 0;
        this.vip = false;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isVip() {
        return vip;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        this.vip = this.loyaltyPoints >= 200;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public void addPoints(int points) {
        if (points <= 0) {
            return;
        }
        this.loyaltyPoints = this.loyaltyPoints + points;
        this.vip = this.loyaltyPoints >= 200;
    }

    public boolean redeemPoints(int points) {
        if (points <= 0) {
            return false;
        }
        if (this.loyaltyPoints < points) {
            return false;
        }
        this.loyaltyPoints = this.loyaltyPoints - points;
        this.vip = this.loyaltyPoints >= 200;
        return true;
    }

    public String getContactCard() {
        return this.name + " | " + this.phoneNumber + " | " + this.email;
    }

    @Override
    public String toString() {
        return "Customer{customerId=" + customerId + ", name='" + name + "', phoneNumber='" + phoneNumber + "', email='" + email + "', loyaltyPoints=" + loyaltyPoints + ", vip=" + vip + "}";
    }
}
