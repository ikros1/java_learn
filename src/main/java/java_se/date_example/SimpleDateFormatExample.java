package java_se.date_example;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        /*
        格式化字符：

        y：年（yyyy，四位及以上     yy：两位年）

        M：月（MM  两位月）

        d：日（dd 两位日期）

        h：12进制小时（hh：两位小时）

        H：24进制小时（HH：两位小时）

        m：分钟

        s：秒

        S：毫秒

        E：星期

        X、Z：时区

        a：上午/下午

        注意：如果想直接显示字母，需要加上单引号
         */
        Date date = new Date();
        System.out.println(date);
        //2024-03-06 15:05
        //如果想直接显示字母，需要加上单引号
        SimpleDateFormat fmt = new SimpleDateFormat("yy年MM月dd日  'at' HH:mm:ss");
        //Date对象转格式化字符串
        String str = fmt.format(date);
        System.out.println(str);
        //格式化字符串转化为日期
        Date date2 = fmt.parse(str,new ParsePosition(0));
        System.out.println(date2);
    }
}
