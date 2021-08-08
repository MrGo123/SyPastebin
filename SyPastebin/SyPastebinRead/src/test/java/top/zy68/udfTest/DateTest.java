package top.zy68.udfTest;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateTest
 * @Description TODO
 * @Author Sustart
 * @Date2021/8/8 23:05
 * @Version 1.0
 **/
public class DateTest {
    @Test
    public void dateSubtract() throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2006-06-08 20:20:20");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2006-06-07 20:20:20");

        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        System.out.println((date1.getTime() - date2.getTime()) / (24*60*60*1000));
    }
}
