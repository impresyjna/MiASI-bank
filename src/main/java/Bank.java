import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private static Bank instance = null;
    //TODO singleton, dodawanie w konstruktorach

    public static Bank getInstance(){
        if(instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUserToList(User user){
        this.users.add(user);
    }

    public void addAccountToList(Account account) { this.accounts.add(account); }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}