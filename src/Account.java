import java.util.Date;
import java.util.List;

public abstract class Account {
	private long ownerId; 
	private Date startDate; 
	private double balance;
	private List<Operation> operations; 
}
