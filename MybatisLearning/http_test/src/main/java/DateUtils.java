
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
    public static String format(String patten){
        DateTimeFormatter fmt = DateTimeFormat.forPattern(patten);
        String dateStr = fmt.print(DateTime.now().getMillis());
        return dateStr;
    }
}
