import java.util.Date;

/**
 * Created by impresyjna on 07.04.2016.
 */
public enum CapitalizeType {
    Daily, Monthly, AtTheEndOfDeposit, Yearly;

    /*public long getCapitalizeDivider(Date startDate, Date endDate) {
        switch (this) {
            case Daily:
                return (int) (endDate.getTime() - startDate.getTime())/ (1000 * 60 * 60 * 24);
                break;
            case Monthly:
                return (int)
                break;
            case AtTheEndOfDeposit:
                System.out.println("Weekends are best.");
                break;
            case Yearly:
                System.out.println("Midweek days are so-so.");
                break;
        }
    } */
}
