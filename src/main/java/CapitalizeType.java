import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by impresyjna on 07.04.2016.
 */
public enum CapitalizeType {
    Daily, Monthly, AtTheEndOfDeposit, Yearly;

    public int getCapitalizePower(Date startDate, Date endDate) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);
        switch (this) {
            case Daily:
                return (int) (endDate.getTime() - startDate.getTime())/ (1000 * 60 * 60 * 24);
            case Monthly:
                int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
            case AtTheEndOfDeposit:
                return 1;
            case Yearly:
                return endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        }
        return 0;
    }

    public int getCapitalizeDivider(){
        switch (this) {
            case Daily:
                return 365;
            case Monthly:
                return 12;
            case AtTheEndOfDeposit:
                return 1;
            case Yearly:
                return 1;
        }
        return 0;
    }
}
