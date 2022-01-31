package javacoreexample.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UsageDateInJava {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.WEEK_OF_MONTH,1);
        System.out.println(calendar.getTime());
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat.format(calendar.getTime()));

        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        System.out.println(simpleDateFormat.format(calendar.getTime()));

        Date newDate = simpleDateFormat.parse("07/02/2003 10:00");
        System.out.println(newDate);

        System.out.println("Usage of method before && after show us," +
                " that we can know if the date1 was created earlier than date2." +
                " Both of them will show us a 'true' result");
        usageOfMethodBefore();
        usageOfMethodAfter();

        System.out.println("Usage of method equals show us," +
                " that we can compare 2 dates according to milliseconds.");
        usageOfMethodEquals();

    }

    private static void usageOfMethodBefore() throws InterruptedException {

        Date date1 = new Date();

        Thread.sleep(2000);
        Date date2 = new Date();

        System.out.println(date1.before(date2));
    }

    private static void usageOfMethodAfter() throws InterruptedException {

        Date date1 = new Date();

        Thread.sleep(2000);
        Date date2 = new Date();

        System.out.println(date2.after(date1));
    }

    private static void usageOfMethodEquals() throws InterruptedException {

        Date date1 = new Date();
        Date date2 = new Date();

        System.out.println(date2.equals(date1));
    }
}
