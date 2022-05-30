package time;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class TimezoneTest {
    @Test
    public void tz() throws ParseException {
        //TimeZone tz = TimeZone.getTimeZone("Australia/Broken_Hill");
        TimeZone tz = TimeZone.getTimeZone("Australia/Berowra");
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        TimeZone.setDefault(tz);
        Calendar cal = Calendar.getInstance(tz, Locale.ENGLISH);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        //Date dateBeforeDST = df.parse("2018-03-25 01:55");
        //cal.setTime(dateBeforeDST);
        System.out.println(df.format(cal.getTime()));
        //assertThat(cal.get(Calendar.ZONE_OFFSET)).isEqualTo(3600000);
        //assertThat(cal.get(Calendar.DST_OFFSET)).isEqualTo(0);
    }

}

