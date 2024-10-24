package java_se.throwable_example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CatchExample {
    public static void main(String[] args) {
        /*
        简单地说就是：多个catch语句只有一个能被执行。例如：

public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e) {
        System.out.println(e);
    } catch (NumberFormatException e) {
        System.out.println(e);
    }
}
存在多个catch的时候，catch的顺序非常重要：子类必须写在前面。例如：

public static void main(String[] args) {
    try {
        process1();
        process2();
        process3();
    } catch (IOException e) {
        System.out.println("IO error");
    } catch (UnsupportedEncodingException e) { // 永远捕获不到
        System.out.println("Bad encoding");
    }
}
对于上面的代码，UnsupportedEncodingException异常是永远捕获不到的，
因为它是IOException的子类。当抛出UnsupportedEncodingException异常时，
会被catch (IOException e) { ... }捕获并执行。
         */
        try {
            process1();
            process2();
            process3();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad encoding");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    public static void process1() throws UnsupportedEncodingException {
        System.out.println("Process 1");
    }
    public static void process2() throws UnsupportedEncodingException {
        System.out.println("Process 2");
    }
    public static void process3() throws UnsupportedEncodingException {
        System.out.println("Process 3");
    }
    /*
    注意finally有几个特点：

finally语句不是必须的，可写可不写；
finally总是最后执行。
如果没有发生异常，就正常执行try { ... }语句块，然后执行finally。如果发生了异常，就中断执行try { ... }语句块，然后跳转执行匹配的catch语句块，最后执行finally。

可见，finally是用来保证一些代码必须执行的。

某些情况下，可以没有catch，只使用try ... finally结构。例如：

void process(String file) throws IOException {
    try {
        ...
    } finally {
        System.out.println("END");
    }
}
     */
}
