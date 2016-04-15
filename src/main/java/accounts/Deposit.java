package accounts;

import enums.CapitalizeType;
import exceptions.NotEnoughMoneyException;
import operations.Interest;
import operations.Substract;

import java.util.Date;

public class Deposit implements Interest {
	private Account account;
	private Date startDate;
	private Date endDate;
	private long duration;
	private double interest = 0;
	private double interestRate;
	private boolean open;
    private double balance;
	private CapitalizeType capitalizeType;

    public static Deposit createDeposit(double balance, double interestRate, Date endDate, Account account, CapitalizeType capitalizeType) throws NotEnoughMoneyException {
    	if(account.doOperation(new Substract(account, balance))) {
    		return new Deposit(balance, interestRate, endDate, account, capitalizeType);
    	}else {
    		throw new NotEnoughMoneyException();
    	}
    }
    
	private Deposit(double balance, double interestRate, Date endDate, Account account, CapitalizeType capitalizeType){
		account.addDeposit(this);
		this.startDate = new Date();
		this.endDate=endDate;
		this.open = true;
		this.balance = balance;
		this.interestRate = interestRate;
		this.account = account;
		this.capitalizeType = capitalizeType;
	}

	@Override
	public void calculateInterest() {
		interest = balance * Math.pow(interestRate / (capitalizeType.getCapitalizeDivider()), capitalizeType.getCapitalizePower(startDate,new Date()));
		System.out.println(interest);
	}

	public boolean closeAccount() {
		//TODO:
		/* if(this.open){
			if(new Date().after(endDate)) {
				calculateInterest();
			}
			account.doOperation(balance+interest, "close deposit");
			this.open = false;
			return true;
		} else {
			return false;
		} */
		return true;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public long getDuration()
	{
		duration = endDate.getTime() - startDate.getTime();
		return duration;
	}

	public double getInterest()
	{
		return interest;
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	
	public Account getAccount() {
		return account;
	}

	
}
