package accounts;

import operations.Operation;
import util.History;
import util.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private User owner;
    private long id;
    private Date startDate;
    private double balance;
    private boolean open;
    private double limit;
    private History history = new History();

    private List<Deposit> deposits = new ArrayList<>();


    public Account(User owner, Date startDate, double balance, boolean open, double limit) {
        this.owner = owner;
        this.startDate = startDate;
        this.balance = balance;
        this.open = open;
        this.limit = limit;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public boolean doOperation(Operation operation){
        boolean correct = operation.execute();
        if(correct) history.log(operation);
        return correct;
    }

    public void addDeposit(Deposit deposit){
        this.deposits.add(deposit);
    }
}
