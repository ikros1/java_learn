package java_se.java_common_tool_class_example.big_number_example;


import java.math.BigInteger;

public class BigIntegerExample {
    public static void main(String args[]) {

        int integerMaximumValue = 2147483647;// This is maximum value for
        // integer type i.e 2 power 31

        System.out.println("Case=1 = " + integerMaximumValue);
        System.out.println("Case=2 = " + (integerMaximumValue + 1));
        System.out.println("Case=3 = " + (integerMaximumValue * 2));
        System.out.println("Case=4 = " + (integerMaximumValue * 4));
        // All the above cases expect Case=1 gives wrong value as overflow
        // occured

        // All the below cases gives expected values as BigInteger Object
        // accomdates more values
        BigInteger bigIntegerdemo = BigInteger.valueOf(integerMaximumValue);
        System.out.println();
        System.out.println("Case=5 " + bigIntegerdemo);
        System.out.println("Case=6 " + bigIntegerdemo.add(BigInteger.ONE));
        System.out.println("Case=7 " + bigIntegerdemo.multiply(BigInteger.valueOf(3)));
        System.out.println("Case=8 " + bigIntegerdemo.multiply(BigInteger.valueOf(4)));
        /*
        BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。
        因为Number定义了转换为基本类型的几个方法：
        转换为byte：byteValue()
        转换为short：shortValue()
        转换为int：intValue()
        转换为long：longValue()
        转换为float：floatValue()
        转换为double：doubleValue()
        因此，通过上述方法，可以把BigInteger转换成基本类型。
        如果BigInteger表示的范围超过了基本类型的范围，
        转换时将丢失高位信息，即结果不一定是准确的。
        如果需要准确地转换成基本类型，
        可以使用intValueExact()、longValueExact()等方法，
        在转换时如果超出范围，将直接抛出ArithmeticException异常。
         */
        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f); // Infinity
    }
}