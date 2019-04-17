package designPattern.singleton.usage;

public interface UserDatabase {
    User readUser(String username);

    void writeUser(User user);
}
