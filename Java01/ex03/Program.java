import java.util.UUID;

public class Program {
    public static void main(String[] args) {

        User user1 = new User("Test1", 150.0);
        User user2 = new User("Test2", 150.0);
        User user3 = new User("Test3", 150.0);

        Transaction t1 = new Transaction(user1, user2, Transaction.Category.CREDIT, 50.0);
        System.out.println(t1);
        Transaction t2 = new Transaction(user2, user3, Transaction.Category.CREDIT, 50.0);
        System.out.println(t2);
        Transaction t3 = new Transaction(user1, user3, Transaction.Category.CREDIT, 50.0);
        System.out.println(t3);
        Transaction t4 = new Transaction(user3, user2, Transaction.Category.CREDIT, 50.0);
        System.out.println(t4);

        System.out.println("----------------------");
        TransactionsLinkedList list = new TransactionsLinkedList(new TransactionNode(t1));
        list.printList();
        System.out.println("----------------------");
        list.addTransaction(t2);
        list.addTransaction(t3);
        list.printList();
        System.out.println("----------------------");
        list.addTransaction(t4);
        list.printList();
        System.out.println("----------------------");

        UUID headId = list.getHead().getData().getId();
        System.out.println("HEAD ID: " + headId);
        System.out.println("---REMOVE HEAD BY ID---");
        list.removeById(headId);
        list.printList();
        UUID newSecondId = list.getHead().getNext().getData().getId();
        System.out.println("SECOND ID: " + newSecondId);
        System.out.println("---REMOVE NEW SECOND BY ID---");
        list.removeById(newSecondId);
        list.printList();
    }
}