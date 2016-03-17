
public class Loan implements Interest{
	private long accountId; 	
	private double interest; 
	private double interestPercent; 
	private double balance; 
	
	private Loan(){
		
	}
	
	@Override
	public void calculateInterest() {
		// TODO Auto-generated method stub
		
	}
	
	public void payOffLoan(){
		balance = 0; 
		interest = 0; 
	}
}
