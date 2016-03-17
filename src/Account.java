import java.util.Date;
import java.util.List;

public abstract class Account {
	protected long ownerId;
	protected Date startDate;
	protected double balance;
	protected List<Operation> operations;
	protected boolean open;

	public abstract boolean closeAccount();
	public abstract Operation addMoney(double money, String description);
	public abstract Operation minusMoney(double money);
	public abstract Operation transferMoney(double money, Account account);

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
}
