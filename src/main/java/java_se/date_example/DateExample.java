package java_se.date_example;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // 调用了System.currentTimeMillis() 系统毫秒数
        Date date = new Date();
        System.out.println(date);
        // 传入系统毫秒数
        Date date2 = new Date(1234567899989L);
        System.out.println(date2);// 2009

        // 获取系统毫秒数
        System.out.println(date.getTime());
        // 设置系统毫秒数
        // date.setTime(1234567899989L);
        System.out.println(date);// 2024

        // 日期比较 返回值 正数第一个日期大 负数第二个日期大 0相同
        System.out.println(date.compareTo(date2));

        // 判断日期是否是另一个日期之后
        System.out.println(date.after(date2));
        // 判断日期是否是另一个日期之前
        System.out.println(date.before(date2));
    }

}
