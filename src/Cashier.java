public class Cashier extends Employee {
    private int transactions;

    public Cashier(int employeeId, String name, double hourlyRate, int experienceYears, boolean active, int transactions) {
        super(employeeId, name, hourlyRate, experienceYears, active);
        setTransactions(transactions);
    }

    public int getTransactions() { return transactions; }

    public void setTransactions(int transactions) {
        if (transactions >= 0) this.transactions = transactions;
        else {
            System.out.println("Warning: Transactions cannot be negative! Setting to 0.");
            this.transactions = 0;
        }
    }

    @Override
    public void work() {
        System.out.println("Cashier " + name + " is processing customer payments.");
    }

    @Override
    public String getRole() {
        return "Cashier";
    }

    public void recordTransaction() {
        if (!active) return;
        transactions++;
    }

    public boolean isFastCashier() {
        return transactions >= 50 && experienceYears >= 2;
    }

    @Override
    public String toString() {
        return super.toString() + " | Transactions: " + transactions;
    }
}
