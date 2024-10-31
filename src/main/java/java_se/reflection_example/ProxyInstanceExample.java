package java_se.reflection_example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstanceExample {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}
interface Hello {
    void morning(String name);
}

/*
这段代码展示了Java中动态代理的一个简单应用。动态代理是一种设计模式，允许你在运行时创建一个实现了一组接口的代理类对象。这个代理类对象可以在调用接口方法时，添加一些额外的行为（比如日志记录、安全检查等），然后再将调用转发给实际的对象。这里使用的是Java的反射机制来实现动态代理。

下面是代码的详细解释：

定义接口：
java
interface Hello {
    void morning(String name);
}
Hello接口定义了一个方法morning(String name)。这是动态代理将要实现的接口。

创建动态代理实例：
在main方法中，首先创建了一个InvocationHandler的匿名类实例。InvocationHandler是一个接口，定义了一个方法invoke(Object proxy, Method method, Object[] args)，这个方法在代理对象的方法被调用时会被自动执行。
java
InvocationHandler handler = new InvocationHandler() {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        if (method.getName().equals("morning")) {
            System.out.println("Good morning, " + args[0]);
        }
        return null;
    }
};
在这个invoke方法中，首先打印了被调用的方法（method），然后检查方法名是否为morning。如果是，就打印一条问候消息。这里的args参数包含了调用morning方法时传递的参数。

使用Proxy.newProxyInstance创建代理对象：
java
Hello hello = (Hello) Proxy.newProxyInstance(
        Hello.class.getClassLoader(), // 传入ClassLoader
        new Class[] { Hello.class }, // 传入要实现的接口
        handler); // 传入处理调用方法的InvocationHandler
Proxy.newProxyInstance方法用于创建动态代理对象。它接收三个参数：

Hello.class.getClassLoader()：类加载器，用于加载代理类。
new Class[] { Hello.class }：代理类要实现的接口数组。这里指定了Hello接口。
handler：一个实现了InvocationHandler接口的实例，用于处理代理实例上的方法调用。
这个方法返回一个实现了Hello接口的代理对象。

调用代理对象的方法：
java
hello.morning("Bob");
当调用hello.morning("Bob")时，实际上调用的是InvocationHandler的invoke方法。invoke方法首先打印了被调用的方法（即java.lang.reflect.Method对象的一个实例），然后检查方法名是否为morning，如果是，则打印一条问候消息。

输出结果将是：

public abstract void Hello.morning(java.lang.String)
Good morning, Bob
第一行输出是invoke方法中打印的method对象，表示被调用的方法。第二行输出是if语句中打印的问候消息。

这个示例展示了如何使用Java的动态代理来在运行时创建接口的代理对象，并在方法调用时添加额外的行为。
 */