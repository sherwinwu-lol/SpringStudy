package designPattern.singleton.usage;

public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();
    public static UserDatabase instance() {
        return theInstance;
    }

    @Override
    public User readUser(String username) {
        // Some Implementation
        return null;
    }

    @Override
    public void writeUser(User user) {
        // Some Implementation
    }
}
/**
 * 这个SINGLETON模式,确保了所有对数据库的访问都通过UserDatabaseSource类的单一实例进行.
 * 在UserDatabaseSource类中放入检查、计数、锁
 **/