import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
	protected long ownerId;
	protected Date startDate;
	protected double balance;
	protected List<Operation> operations = new ArrayList<>();
	protected boolean open;

	public abstract boolean closeAccount();
	public abstract boolean addMoney(double money, String description);
	public abstract boolean minusMoney(double money, String description);
	public abstract boolean transferMoney(double money, Account account, String description);

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public double getBalance() {
		return balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public boolean isOpen() {
		return open;
	}
}
