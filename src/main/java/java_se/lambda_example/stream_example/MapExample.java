package java_se.lambda_example.stream_example;

import java.util.List;
/*
Stream.map()是Stream最常用的一个转换方法，它把一个Stream转换为另一个Stream。

所谓map操作，就是把一种操作运算，映射到一个序列的每一个元素上。例如，对x计算它的平方，可以使用函数f(x) = x * x。我们把这个函数映射到一个序列1，2，3，4，5上，就得到了另一个序列1，4，9，16，25：

            f(x) = x * x

                  │
  ┌───┬───┬───┬───┼───┬───┬───┬───┐
  │   │   │   │   │   │   │   │   │
  ▼   ▼   ▼   ▼   ▼   ▼   ▼   ▼   ▼

[ 1   2   3   4   5   6   7   8   9 ]

  │   │   │   │   │   │   │   │   │
  ▼   ▼   ▼   ▼   ▼   ▼   ▼   ▼   ▼

[ 1   4   9  16  25  36  49  64  81 ]
可见，map操作，把一个Stream的每个元素一一对应到应用了目标函数的结果上。

Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
Stream<Integer> s2 = s.map(n -> n * n);
如果我们查看Stream的源码，会发现map()方法接收的对象是Function接口对象，它定义了一个apply()方法，负责把一个T类型转换成R类型：

<R> Stream<R> map(Function<? super T, ? extends R> mapper);
其中，Function的定义是：

@FunctionalInterface
public interface Function<T, R> {
    // 将T类型转换为R:
    R apply(T t);
}
利用map()，不但能完成数学计算，对于字符串操作，以及任何Java对象都是非常有用的。例如：

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }
}
通过若干步map转换，可以写出逻辑简单、清晰的代码。

练习
使用map()把一组String转换为LocalDate并打印。
 */
public class MapExample {
    public static void main(String[] args) {
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }
}
