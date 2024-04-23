public class TransactionNode {
    private TransactionNode next;
    private Transaction data;

    public TransactionNode(Transaction data) {
        this.data = data;
        this.next = null;
    }
    public TransactionNode getNext() {
        return next;
    }

    public Transaction getData() {
        return data;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }
}