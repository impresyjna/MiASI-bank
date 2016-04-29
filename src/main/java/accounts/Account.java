package accounts;

import operations.Income;
import operations.Operation;
import operations.Substract;
import operations.Transfer;
import util.Bank;
import util.History;
import util.User;
import util.VisitorInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TODO: Numer konta
public class Account implements AccountInterface {
    private User owner;
    private long id;
    private Date startDate;
    private double balance;
    private boolean open;
    private History history = new History();

    private List<Deposit> deposits = new ArrayList<>();


    public Account(User owner, double balance, Bank bank) {
        this.owner = owner;
        this.startDate = new Date();
        this.balance = balance;
        this.open = true;
        bank.addAccountToList(this);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
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

    @Override
    public boolean income(double amount) {
        Income operation = new Income(this, amount);
        return this.doOperation(operation);
    }

    @Override
    public boolean substract(double amount) {
        Substract operation = new Substract(this, amount);
        return this.doOperation(operation);
    }

    @Override
    public boolean transfer(Account to, double amount) {
        Transfer operation = new Transfer(this, to, amount);
        return this.doOperation(operation);
    }

    @Override
    public Void accept(VisitorInterface visitor) {
        return visitor.visit(this);
    }



    public void addDeposit(Deposit deposit){
        this.deposits.add(deposit);
    }
}
