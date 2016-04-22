package util;

import accounts.Account;
import operations.Income;
import operations.Operation;
import operations.Substract;
import operations.Transfer;

import java.util.ArrayList;
import java.util.List;

//TODO: Wzorzecz State do naliczania odsetek
//TODO: Wzorzec Decorator (do konta debetowego)
//TODO: Wzorzec mediator do rozliczeń międzybankowych (ELIXIR)
public class Bank {
    private List<User> users = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

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

    public boolean income(Account account, double amount){
        Operation operation = new Income(account, amount);
        return account.doOperation(operation);
    }

    public boolean substract(Account account, double amount){
        Operation operation = new Substract(account, amount);
        return account.doOperation(operation);
    }

    public boolean transfer(Account from, Account to, double amount){
        Operation operation = new Transfer(from, to, amount);
        return from.doOperation(operation);
    }
}