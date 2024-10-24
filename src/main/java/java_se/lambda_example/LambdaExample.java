package java_se.lambda_example;

import java.util.Arrays;

public class LambdaExample {
    public static void main(String[] args) {
        /*
        在Java程序中，我们经常遇到一大堆单方法接口，即一个接口只定义了一个方法：

        Comparator
        Runnable
        Callable
        以Comparator为例，我们想要调用Arrays.sort()时，可以传入一个Comparator实例，以匿名类方式编写如下：
        String[] array = ...
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
         */
        //下面的代码为Lambda表达式替换单接口方法
        String[] array = new String[] { "Appleeeeeeeeeee", "Orangeeeee", "Banana", "Lemon" };
        Arrays.sort(array, (s1, s2) -> {
            if(s1.length() > s2.length()){
                return 1;
            }
            else {
                return -1;
            }
        });
        System.out.println(String.join(", ", array));
        //观察Lambda表达式的写法，它只需要写出方法定义：
        //
        //(s1, s2) -> {
        //    return s1.compareTo(s2);
        //}
        //其中，参数是(s1, s2)，参数类型可以省略，因为编译器可以自动推断出String类型。-> { ... }表示方法体，所有代码写在内部即可。Lambda表达式没有class定义，因此写法非常简洁。
        //
        //如果只有一行return xxx的代码，完全可以用更简单的写法：
        //
        //Arrays.sort(array, (s1, s2) -> s1.compareTo(s2));
        //返回值的类型也是由编译器自动推断的，这里推断出的返回值是int，因此，只要返回int，编译器就不会报错。
/*
FunctionalInterface
我们把只定义了单方法的接口称之为FunctionalInterface，用注解@FunctionalInterface标记。例如，Callable接口：

@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
再来看Comparator接口：

@FunctionalInterface
public interface Comparator<T> {

    int compare(T o1, T o2);

    boolean equals(Object obj);

    default Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }

    default Comparator<T> thenComparing(Comparator<? super T> other) {
        ...
    }
    ...
}
虽然Comparator接口有很多方法，但只有一个抽象方法int compare(T o1, T o2)，
其他的方法都是default方法或static方法。
另外注意到boolean equals(Object obj)是Object定义的方法，不算在接口方法内
因此，Comparator也是一个FunctionalInterface。
 */
    }
}
