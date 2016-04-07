import java.util.Date;

public class Deposit implements Interest  {
	private Account account;
	private Date startDate;
	private Date endDate;
	private long duration;
	private double interest = 0;
	private double interestRate;
	private boolean open;
    private double balance;

    public static Deposit createDeposit(double balance, double interestRate, Date endDate, Account account) throws NotEnoughMoneyException {
    	if(account.minusMoney(balance, "create deposit")) {
    		return new Deposit(balance, interestRate, endDate, account);
    	}else {
    		throw new NotEnoughMoneyException();
    	}
    }
    
	private Deposit(double balance, double interestRate, Date endDate, Account account){
		account.addDeposit(this);
		this.startDate = new Date();
		this.endDate=endDate;
		this.open = true;
		this.balance = balance;
		this.interestRate = interestRate;
		this.account = account;
	}

	@Override
	public void calculateInterest() {
		interest = balance * interestRate;
	}

	public boolean closeAccount() {
		if(this.open){
			if(new Date().after(endDate)) {
				calculateInterest();
			}
			account.addMoney(balance+interest, "close deposit");
			this.open = false;
			return true;
		} else {
			return false;
		}
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
