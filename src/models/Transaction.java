package models;

/**
 *
 * @author Rodrigo Oliveira 29.655.609
 */
public class Transaction {
    private String name;
    private double amount;

    public Transaction(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Transaction(String name) {
        this.name = name;
        this.amount = 0.0;
    }
    
    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean isWithAmount() {
        return this.amount > 0;
    }
}
