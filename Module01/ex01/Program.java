public class Program {
    public static void main(String[] args) {
        User u1 = new User("Matteo", 150.0);

        System.out.println(u1);
        System.out.println("Background call constructor * 100");
        for (int i = 0; i <= 100; i++) {
            u1 = new User("Matteo", 150.0);
        }
        System.out.println(u1);
    }
}