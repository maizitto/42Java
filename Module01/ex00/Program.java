public class Program {
    public static void main(String[] args) {
        User user1 = new User("Matteo", 100.0);
        User user2 = new User("Test", 150.0);
        Transaction t1 = new Transaction(user1, user2, Transaction.Category.CREDIT, 50);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(t1);
    }
}