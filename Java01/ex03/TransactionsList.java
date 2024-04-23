import java.util.UUID;

interface TransactionsList {
    public void addTransaction(Transaction t);
    public void removeById(UUID id);
    public Transaction[] toArray();

    public class TransactionNotFoundException extends RuntimeException {
        public	TransactionNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}