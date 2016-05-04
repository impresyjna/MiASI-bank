package util;

import accounts.Account;
import accounts.AccountInterface;
import operations.Income;
import operations.Operation;
import operations.Substract;
import operations.Transfer;

import java.util.ArrayList;
import java.util.List;

//TODO: Wzorzecz State do naliczania odsetek
//TODO: Wzorzec Decorator (do konta debetowego)
//TODO: Wzorzec mediator do rozliczeń międzybankowych (ELIXIR)
//TODO: Wzorzec Visitor do tworzenia raportów (wybiera obiekty które pasują i odwiedzając je zbiera informacje i tworzy raport)
//TODO: Nadawanie numeru konta
//TODO: Identyfikator banku
public class Bank {
    private List<User> users = new ArrayList<>();
    private List<AccountInterface> accounts = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUserToList(User user) {
        this.users.add(user);
    }

    public void addAccountToList(AccountInterface account) {
        this.accounts.add(account);
    }

    public List<AccountInterface> getAccounts() {
        return accounts;
    }

    public boolean income(Account account, double amount) {
        Operation operation = new Income(account, amount);
        return account.doOperation(operation);
    }

    public boolean substract(Account account, double amount) {
        Operation operation = new Substract(account, amount);
        return account.doOperation(operation);
    }

    public boolean transfer(Account from, Account to, double amount) {
        Operation operation = new Transfer(from, to, amount);
        return from.doOperation(operation);
    }

    public List<AccountInterface> doReport(VisitorInterface visitor) {
        List<AccountInterface> result = new ArrayList<>();
        for (AccountInterface account : accounts) {
            AccountInterface acc = (AccountInterface) account.accept(visitor);
            if (acc != null) {
                result.add(acc);
            }
        }
        return result;
    }

    public double doSumReport(VisitorInterface visitor) {
        double sum = 0;
        for (AccountInterface account : accounts) {
            double value = (double) account.accept(visitor);
            sum += value;
        }
        return sum;
    }
}