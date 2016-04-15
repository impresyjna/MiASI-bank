package util;

import accounts.Account;
import accounts.Deposit;
import operations.CloseAccount;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id; 
	private String name; 
	private String surname; 
	private List<Account> accounts = new ArrayList<>();
	private Bank bank = Bank.getInstance();
	private List<Deposit> deposits = new ArrayList<>();

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
		account.setOwner(this);
	}

	public void removeAccount(Account account){
		if(account.doOperation(new CloseAccount(account))){
			accounts.remove(account);
		}
	}
	

	public void addDeposit(Deposit deposit){
		this.deposits.add(deposit);
	}
}
