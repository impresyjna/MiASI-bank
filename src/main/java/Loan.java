
public class Loan extends Account implements Interest{
	private long accountId; 	
	private double interest; 
	private double interestPercent; 
	private double balance; 
	
	private Loan(long accountId, double interest, double interestPercent, double balance){
		this.accountId = accountId;
		this.interest = interest;
		this.interestPercent = interestPercent;
		this.balance = balance;
	}
	
	@Override
	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
	
	public void payOffLoan(){
		balance = 0; 
		interest = 0; 
	}

	@Override
	public boolean closeAccount() {
		//TODO:
		return false;
	}

	@Override
	public boolean addMoney(double money, String description) {
		//TODO:
		return true;
	}

	@Override
	public boolean minusMoney(double money, String description) {
		//TODO:
		return true;
	}

	@Override
	public boolean transferMoney(double money, Account account, String description) {
		//TODO:
		return true;
	}
}
