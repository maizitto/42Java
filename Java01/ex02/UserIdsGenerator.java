public class UserIdsGenerator {
    private static int id;
    private static UserIdsGenerator instance = null;

    public UserIdsGenerator() {
        this.id = 0;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return (this.id++);
    }
}