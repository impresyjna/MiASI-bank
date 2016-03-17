import java.util.List;

public class User {
	private int id; 
	private String name; 
	private String surname; 
	private List<Account> accounts;
	
	public User(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public void addAccount(Account account){
		this.accounts.add(account);
		account.setOwnerId(this.id);
	}

	public void removeAccount(Account account){
		if(account.closeAccount()){
			accounts.remove(account);
		}
	}
}
