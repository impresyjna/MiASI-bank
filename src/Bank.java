import java.util.List;

public class Bank {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void addUserToList(User user){
        this.users.add(user);
    }
}