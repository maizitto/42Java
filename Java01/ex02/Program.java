public class Program {
    public static void main(String[] args) {
        UsersArrayList list = new UsersArrayList();

        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        System.out.println("size list: " + list.getSize());
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        list.addUser(new User("test1", 150.0));
        System.out.println("size list: " + list.getSize());
    }
}