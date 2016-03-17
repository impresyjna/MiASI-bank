import java.util.Date;

public class Operation {
	private Date executionTime;
	private String description;
	private OperationType type;
	private Account account;
	private double balance;
	private Account secondAccountForTransfer;

	public Operation(double balance, Date executionTime, String description, OperationType type, Account account) {
		this.balance = balance;
		this.executionTime = executionTime;
		this.description = description;
		this.type = type;
		this.account = account;
	}

	public void setSecondAccountForTransfer(Account secondAccountForTransfer) {
		this.secondAccountForTransfer = secondAccountForTransfer;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public String getDescription() {
		return description;
	}

	public OperationType getType() {
		return type;
	}

	public Account getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}

	public Account getSecondAccountForTransfer() {
		return secondAccountForTransfer;
	}
}
