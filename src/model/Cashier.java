package model;

public class Cashier extends Employee {
    private int transactions;

    public Cashier(int id, String name, double rate, int exp, boolean active, int transactions) {
        super(id, name, rate, exp, active);
        setTransactions(transactions);
    }

    public void setTransactions(int transactions) {
        if (transactions < 0)
            throw new IllegalArgumentException("Transactions cannot be negative");
        this.transactions = transactions;
    }

    public int getTransactions() {
        return transactions;
    }

    @Override
    public void work() {
        System.out.println("Cashier " + name + " is processing payments.");
    }

    @Override
    public String getRole() {
        return "Cashier";
    }

    public boolean isFastCashier() {
        return transactions >= 50 && experienceYears >= 2;
    }
}
