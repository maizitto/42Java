interface UsersList {
    public void addUser(User u);

    public User searchId(int id);

    public User searchIndex(int index);

    public int getSize();

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}