import java.util.Random;

public class User {
    private int id;
    private String name;
    private double balance;

    public User() {
        this.id = 0;
        this.name = "Default";
        this.balance = 0.0;
    }

    public User(String name, double balance) {
        this.name = name;
        if (balance < 0) {
            System.out.println("Negative balance not Allowed (0 Default setted)");
            this.balance = 0;
        }
        else {
            this.balance = balance;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Account ID: " + getId() + " - " + "Account Name: " + getName() + " - " +
                "Balance: " + getBalance());
    }
}