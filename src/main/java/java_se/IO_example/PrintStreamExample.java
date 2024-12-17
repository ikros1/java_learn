package java_se.IO_example;
/*
PrintStream是一种FilterOutputStream，它在OutputStream的接口上，额外提供了一些写入各种数据类型的方法：

写入int：print(int)
写入boolean：print(boolean)
写入String：print(String)
写入Object：print(Object)，实际上相当于print(object.toString())
...
以及对应的一组println()方法，它会自动加上换行符。

我们经常使用的System.out.println()实际上就是使用PrintStream打印各种数据。其中，System.out是系统默认提供的PrintStream，表示标准输出：

System.out.print(12345); // 输出12345
System.out.print(new Object()); // 输出类似java.lang.Object@3c7a835a
System.out.println("Hello"); // 输出Hello并换行
System.err是系统默认提供的标准错误输出。

PrintStream和OutputStream相比，除了添加了一组print()/println()方法，可以打印各种数据类型，比较方便外，它还有一个额外的优点，就是不会抛出IOException，这样我们在编写代码的时候，就不必捕获IOException。
 */
public class PrintStreamExample {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(new Object());
        System.out.print("NO LINE");
        System.err.println("this is a error message");
    }
}
