import java.util.Date;

public class Deposit implements Interest{
	private long accountId;
	private Date endTime; 
	private Date startTime; 
	private int duration; 
	private double balance; 
	private double interest; 
	private double interestRate; 
	
	private Deposit(){
		long diffInMillies = endTime.getTime() - startTime.getTime();
	    this.duration = (int) diffInMillies/(24*60*60*1000); 
	}

	@Override
	public void calculateInterest() {
		interest = balance * interestRate; 
	} 
}
