import java.util.List;

public class User {
	private int id; 
	private String name; 
	private String surname; 
	private List<Account> accounts;
	private Bank bank = Bank.getInstance();
	private List<Deposit> deposits;

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
		bank.addUserToList(this);
		this.id = bank.getUsers().lastIndexOf(this);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public List<Account> getAccounts() {
		return accounts;
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
	

	public void addDeposit(Deposit deposit){
		this.deposits.add(deposit);
	}
}
