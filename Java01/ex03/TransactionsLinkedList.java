import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    TransactionNode head;
    private int size;

    public TransactionsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public TransactionsLinkedList(TransactionNode head) {
        this.head = head;
        this.size = 1;
    }

    public void addTransaction(Transaction t){
        TransactionNode x = new TransactionNode(t);
        if (head == null)
            this.head = x;
        else {
            TransactionNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(x);
        }
        this.size++;
    }
    public void removeById(UUID id){
        TransactionNode current = this.head;
        TransactionNode back = null;
        while (current.getNext() != null) {
            if (current.getData().getId() == id && back == null){
                this.head = current.getNext();
                this.size--;
                return ;
            }
            else if (current.getData().getId() == id && back != null) {
                TransactionNode tmp = current.getNext();
                back.setNext(tmp);
                this.size--;
                return ;
            }
            back = current;
            current = current.getNext();
        }
        throw new TransactionNotFoundException("Transaction not found");
    }
    public Transaction[] toArray(){
        TransactionNode current = this.head;
        Transaction list[] = new Transaction[this.size];
        for (int i = 0; i < this.size; i++) {
            list[i] = current.getData();
            current = current.getNext();
        }
        return list;
    }

    public void				printList() {
        TransactionNode	current = this.head;
        System.out.println("Dimensions List: " + this.size);
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public TransactionNode getHead() {
        return head;
    }
}