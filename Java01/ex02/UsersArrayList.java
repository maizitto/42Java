public class UsersArrayList implements UsersList {

    private User users[];
    private int size;
    private int maxSize = 10;

    public UsersArrayList() {
        this.users = new User[maxSize];
        this.size = 0;
    }

    public void addUser(User x) {
        if (getSize() < maxSize){
            this.users[size] = x;
            this.size++;
        }
        else
        {
            this.maxSize += (maxSize / 2);
            User temp[] = new User[maxSize];
            for (int i = 0; i < this.size; i++) {
                temp[i] = this.users[i];
            }
            this.users = temp;
            addUser(x);
        }
    }

    public User searchId(int id) {
        for (int i = 0; i < this.size; i++) {
            if (this.users[i].getId() == id) {
                return (this.users[i]);
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public User searchIndex(int index) {
        if (index < 0 || index > size) {
            throw new UserNotFoundException("User not found");
        }
        else {
            return this.users[index];
        }
    }

    public int getSize() {
        return this.size;
    }
}