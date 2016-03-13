import java.util.List;

public class User {
	private int id; 
	private String name; 
	private String surname; 
	private List<Account> accounts;
	
	public User(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	} 
	
	public void addAccount(Account account){
		this.accounts.add(account); 
	}
	
	public void removeAccount(Account account){
		//TODO
	}
}
