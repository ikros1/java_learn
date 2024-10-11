package java_se.date_example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

//		Calendar cal2 = new GregorianCalendar();
//		System.out.println(cal2);

        // 获取年份
        System.out.println(cal.get(Calendar.YEAR));
        // 获取月份 月份从0开始
        System.out.println(cal.get(Calendar.MONTH) + 1);
        // 获取日期
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        // 获取小时（12进制）
        System.out.println(cal.get(Calendar.HOUR));
        // 获取小时（24进制）
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        // 获取分钟
        System.out.println(cal.get(Calendar.MINUTE));
        // 获取秒
        System.out.println(cal.get(Calendar.SECOND));
        // 获取毫秒
        System.out.println(cal.get(Calendar.MILLISECOND));
        // 获取星期 星期是从1开始 星期日是1
        System.out.println(cal.get(Calendar.DAY_OF_WEEK) - 1);

        //设置时间
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DATE, 10);
        System.out.println(cal);

        // 获取Date对象
        Date date = cal.getTime();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(fmt.format(date));

        Calendar cal2 = Calendar.getInstance();
        //Date对象转Calendar
        cal2.setTime(date);
        System.out.println(cal2);

        // 获取系统毫秒数
        System.out.println(cal2.getTimeInMillis());
        // 设置系统毫秒数
        cal2.setTimeInMillis(1234567891111L);
        System.out.println(cal2);
    }
}
