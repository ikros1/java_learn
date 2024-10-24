package java_se.java_common_tool_class_example.big_number_example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        //和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数。
        BigDecimal bd = new BigDecimal("3.14999999999999999999999999999999");
        BigDecimal bd2 = BigDecimal.valueOf(39999999999999999999999999999999.14);
        //上述为两种赋值方法
        System.out.println(bd);
        System.out.println(bd2);
        //BigDecimal用Scale（）表示小数位数
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0
        //通过BigDecimal的stripTrailingZeros()方法，
        // 可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
        BigDecimal d21 = new BigDecimal("123.4500");
        BigDecimal d22 = d1.stripTrailingZeros();
        System.out.println(d21.scale()); // 4
        System.out.println(d22.scale()); // 2,因为去掉了00

        BigDecimal d23 = new BigDecimal("1234500");
        BigDecimal d24 = d3.stripTrailingZeros();
        System.out.println(d23.scale()); // 0
        System.out.println(d24.scale()); // -2
        //如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0.
        // 可以对一个BigDecimal设置它的scale，如果精度比原始值低，
        // 那么按照指定的方法进行四舍五入或者直接截断：
        BigDecimal d41 = new BigDecimal("123.456789");
        BigDecimal d42 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
        BigDecimal d43 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
        System.out.println(d42);
        System.out.println(d43);
        //对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，
        // 存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：
        BigDecimal dd1 = new BigDecimal("123.456");
        BigDecimal dd2 = new BigDecimal("23.456789");
        BigDecimal dd3 = dd1.divide(dd2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
        //BigDecimal dd4 = dd1.divide(dd2); // 报错：ArithmeticException，因为除不尽
        System.out.println(dd3);
        //System.out.println(dd4);
        //还可以对BigDecimal做除法的同时求余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105
        //调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，分别是商和余数，
        // 其中商总是整数，余数不会大于除数。我们可以利用这个方法判断两个BigDecimal是
        // 否是整数倍数：
        BigDecimal nn = new BigDecimal("12.75");
        BigDecimal mm = new BigDecimal("0.15");
        BigDecimal[] drr = nn.divideAndRemainder(mm);
        if (drr[1].signum() == 0) {
            // n是m的整数倍
            System.out.println("n是m的整数倍");
        }
        //在比较两个BigDecimal的值是否相等时，要特别注意，
        // 使用equals()方法不但要求两个BigDecimal的值相等，
        // 还要求它们的scale()相等：
        BigDecimal da1 = new BigDecimal("123.456");
        BigDecimal da2 = new BigDecimal("123.45600");
        System.out.println(da1.equals(da2)); // false,因为scale不同
        System.out.println(da1.equals(da2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为3
        System.out.println(da1.compareTo(da2)); // 0 = 相等, -1 = d1 < d2, 1 = d1 > d2
    }
}
