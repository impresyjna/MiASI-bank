import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends Account implements Interest{
	private long accountId;
	private Date endDate;
	private int duration;
	private double interest = 0;
	private double interestRate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private Deposit(double balance, double interestRate, Date endDate){
		try {
			this.endDate = dateFormat.parse(endDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diffInMillies = endDate.getTime() - startDate.getTime();
	    this.duration = (int) diffInMillies/(24*60*60*1000);
		this.open = true;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	@Override
	public void calculateInterest() {
		interest = balance * interestRate;
	}

	@Override
	public boolean closeAccount() {
		if(this.open){
			//TODO:
			try {
				if(endDate.equals(dateFormat.parse((new Date()).toString()))){
					calculateInterest();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.open = false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Operation addMoney(double money, String description) {
		//TODO:
		return null;
	}

	@Override
	public Operation minusMoney(double money) {
		//TODO:
		return null;
	}

	@Override
	public Operation transferMoney(double money, Account account) {
		//TODO:
		return null;
	}
}
