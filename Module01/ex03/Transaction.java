import java.util.UUID;

public class Transaction {

    static enum Category {
        DEBIT,
        CREDIT
    }

    private UUID id;
    private User receiver;
    private User sender;
    private double transferAmount;
    private Category category;

    public Transaction(User r, User s, Category cat, double cash) {
        this.id = UUID.randomUUID();
        this.receiver = r;
        this.sender = s;
        this.category = cat;
        if (cat == Category.DEBIT && cash > 0 || cat == Category.CREDIT && cash < 0) {
            System.err.println("Invalid type of transaction");
            cash = 0;
        }
        this.transferAmount = cash;
    }

    public UUID getId() {
        return id;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "id=" + id +
                ", receiver = " + receiver.getName() +
                ", sender = " + sender.getName() +
                ", transferAmount = " + transferAmount +
                ", category = " + category + " " +
                '}';
    }
}