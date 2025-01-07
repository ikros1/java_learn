package java_se.thread_example;
/*
如果线程需要执行一个长时间任务，就可能需要能中断线程。中断线程就是其他线程给该线程发一个信号，该线程收到信号后结束执行run()方法，使得自身线程能立刻结束运行。

我们举个栗子：假设从网络下载一个100M的文件，如果网速很慢，用户等得不耐烦，就可能在下载过程中点“取消”，这时，程序就需要中断下载线程的执行。

中断一个线程非常简单，只需要在其他线程中对目标线程调用interrupt()方法，目标线程需要反复检测自身状态是否是interrupted状态，如果是，就立刻结束运行。

我们还是看示例代码：

// 中断线程
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
仔细看上述代码，main线程通过调用t.interrupt()方法中断t线程，但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”，至于t线程是否能立刻响应，要看具体代码。而t线程的while循环会检测isInterrupted()，所以上述代码能正确响应interrupt()请求，使得自身立刻结束运行run()方法。

如果线程处于等待状态，例如，t.join()会让main线程进入等待状态，此时，如果对main线程调用interrupt()，join()方法会立刻抛出InterruptedException，因此，目标线程只要捕获到join()方法抛出的InterruptedException，就说明有其他线程对其调用了interrupt()方法，通常情况下该线程应该立刻结束运行。

我们来看下面的示例代码：

// 中断线程
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
main线程通过调用t.interrupt()从而通知t线程中断，而此时t线程正位于hello.join()的等待中，此方法会立刻结束等待并抛出InterruptedException。由于我们在t线程中捕获了InterruptedException，因此，就可以准备结束该线程。在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。如果去掉这一行代码，可以发现hello线程仍然会继续运行，且JVM不会退出。

另一个常用的中断线程的方法是设置标志位。我们通常会用一个running标志位来标识线程是否应该继续运行，在外部线程中，通过把HelloThread.running置为false，就可以让线程结束：

// 中断线程
public class Main {
    public static void main(String[] args)  throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }
}

class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}
注意到HelloThread的标志位boolean running是一个线程间共享的变量。线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值。

为什么要对线程间共享的变量用关键字volatile声明？这涉及到Java的内存模型。在Java虚拟机中，变量的值保存在主内存中，但是，当线程访问变量时，它会先获取一个副本，并保存在自己的工作内存中。如果线程修改了变量的值，虚拟机会在某个时刻把修改后的值回写到主内存，但是，这个时间是不确定的！

┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐
           Main Memory
│                               │
   ┌───────┐┌───────┐┌───────┐
│  │ var A ││ var B ││ var C │  │
   └───────┘└───────┘└───────┘
│     │ ▲               │ ▲     │
 ─ ─ ─│─│─ ─ ─ ─ ─ ─ ─ ─│─│─ ─ ─
      │ │               │ │
┌ ─ ─ ┼ ┼ ─ ─ ┐   ┌ ─ ─ ┼ ┼ ─ ─ ┐
      ▼ │               ▼ │
│  ┌───────┐  │   │  ┌───────┐  │
   │ var A │         │ var C │
│  └───────┘  │   │  └───────┘  │
   Thread 1          Thread 2
└ ─ ─ ─ ─ ─ ─ ┘   └ ─ ─ ─ ─ ─ ─ ┘
这会导致如果一个线程更新了某个变量，另一个线程读取的值可能还是更新前的。例如，主内存的变量a = true，线程1执行a = false时，它在此刻仅仅是把变量a的副本变成了false，主内存的变量a还是true，在JVM把修改后的a回写到主内存之前，其他线程读取到的a的值仍然是true，这就造成了多线程之间共享的变量不一致。

因此，volatile关键字的目的是告诉虚拟机：

每次访问变量时，总是获取主内存的最新值；
每次修改变量后，立刻回写到主内存。
volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。

如果我们去掉volatile关键字，运行上述程序，发现效果和带volatile差不多，这是因为在x86的架构下，JVM回写主内存的速度非常快，但是，换成ARM的架构，就会有显著的延迟。

小结
对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。如果目标线程处于等待状态，该线程会捕获到InterruptedException；

目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；

通过标志位判断需要正确使用volatile关键字；

volatile关键字解决了共享变量在线程间的可见性问题。
 这段代码展示了如何使用Java中的多线程和线程中断机制。下面是对代码的详细解释：

### 类和方法结构

1. **Main类**:
    - 包含`main`方法，这是程序的入口点。
    - 创建了一个`MyThread`对象`t`并启动它。
    - 主线程休眠1秒后，中断`t`线程。
    - 使用`join`方法等待`t`线程结束。
    - 最后打印"end"。

2. **MyThread类**:
    - 继承自`Thread`类。
    - 重写了`run`方法，在其中创建并启动了一个`HelloThread`对象`hello`。
    - 使用`join`方法等待`hello`线程结束。
    - 如果`join`方法被中断，会捕获`InterruptedException`并打印"interrupted!"。
    - 最后中断`hello`线程。

3. **HelloThread类**:
    - 继承自`Thread`类。
    - 重写了`run`方法，在其中有一个无限循环，每次循环打印一个递增的数字和"hello!"。
    - 在每次循环中，线程会休眠100毫秒。
    - 如果在休眠期间线程被中断，会捕获`InterruptedException`并退出循环。

### 执行流程

1. **Main类的main方法**:
    - 创建并启动`MyThread`对象`t`。
    - 主线程休眠1秒。
    - 中断`t`线程。
    - 等待`t`线程结束。
    - 打印"end"。

2. **MyThread类的run方法**:
    - 创建并启动`HelloThread`对象`hello`。
    - 等待`hello`线程结束。
    - 如果`join`方法被中断，打印"interrupted!"。
    - 中断`hello`线程。

3. **HelloThread类的run方法**:
    - 进入无限循环，每次循环打印一个递增的数字和"hello!"。
    - 每次循环中，线程会休眠100毫秒。
    - 如果在休眠期间线程被中断，退出循环。

### 关键点

- **线程中断**:
    - `t.interrupt()`：中断`t`线程。
    - `hello.interrupt()`：中断`hello`线程。
    - `isInterrupted()`：检查线程是否被中断。
    - `Thread.sleep(100)`：使线程休眠100毫秒，如果在此期间线程被中断，会抛出`InterruptedException`。

- **join方法**:
    - `t.join()`：等待`t`线程结束。
    - `hello.join()`：等待`hello`线程结束。
    - 如果调用`join`的方法被中断，会抛出`InterruptedException`。

### 输出示例

假设程序运行时没有其他干扰，输出可能如下：

```
1 hello!
2 hello!
3 hello!
4 hello!
5 hello!
6 hello!
7 hello!
8 hello!
9 hello!
10 hello!
interrupted!
end
```

在这个例子中，`HelloThread`线程每100毫秒打印一次消息，直到主线程中断`t`线程，然后`t`线程中断`hello`线程，`hello`线程退出循环，`t`线程结束，最后主线程打印"end"。
所以说程序有两种结果，一个是在运行中while检测到hellothread中断退出循环，第二个是在hellothread中sleep中等待时中断触发interruptedexception退出循环
是的，你理解得非常正确。`HelloThread`线程的退出有两种可能的情况，具体取决于中断发生的时间点。下面是详细的解释：

### 两种退出情况

1. **在`while`循环中检测到中断退出循环**:
    - `HelloThread`线程的`run`方法中有一个`while (!isInterrupted())`循环。
    - 如果在循环体内（即在`System.out.println(n + " hello!");`之后，但在`Thread.sleep(100);`之前），`t.interrupt()`被调用，那么`isInterrupted()`会返回`true`，循环条件不再满足，循环立即退出。

2. **在`Thread.sleep(100)`中等待时中断触发`InterruptedException`退出循环**:
    - 如果`HelloThread`线程正在执行`Thread.sleep(100);`时被中断，`Thread.sleep`方法会抛出`InterruptedException`。
    - 捕获到`InterruptedException`后，`HelloThread`线程会执行`break;`语句，从而退出循环。

### 具体执行流程

#### 情况一：在`while`循环中检测到中断退出循环

1. **Main类的main方法**:
    - 创建并启动`MyThread`对象`t`。
    - 主线程休眠1秒。
    - 中断`t`线程。
    - 等待`t`线程结束。
    - 打印"end"。

2. **MyThread类的run方法**:
    - 创建并启动`HelloThread`对象`hello`。
    - 等待`hello`线程结束。
    - 如果`join`方法被中断，打印"interrupted!"。
    - 中断`hello`线程。

3. **HelloThread类的run方法**:
    - 进入无限循环，每次循环打印一个递增的数字和"hello!"。
    - 每次循环中，线程会休眠100毫秒。
    - 假设在`System.out.println(n + " hello!");`之后，但在`Thread.sleep(100);`之前，`t.interrupt()`被调用，`isInterrupted()`返回`true`，循环条件不再满足，循环立即退出。

#### 情况二：在`Thread.sleep(100)`中等待时中断触发`InterruptedException`退出循环

1. **Main类的main方法**:
    - 创建并启动`MyThread`对象`t`。
    - 主线程休眠1秒。
    - 中断`t`线程。
    - 等待`t`线程结束。
    - 打印"end"。

2. **MyThread类的run方法**:
    - 创建并启动`HelloThread`对象`hello`。
    - 等待`hello`线程结束。
    - 如果`join`方法被中断，打印"interrupted!"。
    - 中断`hello`线程。

3. **HelloThread类的run方法**:
    - 进入无限循环，每次循环打印一个递增的数字和"hello!"。
    - 每次循环中，线程会休眠100毫秒。
    - 假设在`Thread.sleep(100);`期间，`t.interrupt()`被调用，`Thread.sleep`方法会抛出`InterruptedException`。
    - 捕获到`InterruptedException`后，`HelloThread`线程会执行`break;`语句，从而退出循环。

### 输出示例

#### 情况一：在`while`循环中检测到中断退出循环

```
1 hello!
2 hello!
3 hello!
4 hello!
5 hello!
6 hello!
7 hello!
8 hello!
9 hello!
10 hello!
end
```

#### 情况二：在`Thread.sleep(100)`中等待时中断触发`InterruptedException`退出循环

```
1 hello!
2 hello!
3 hello!
4 hello!
5 hello!
6 hello!
7 hello!
8 hello!
9 hello!
10 hello!
interrupted!
end
```

在这两种情况下，`HelloThread`线程都会最终退出循环，但退出的具体原因不同。
第一种情况是因为`isInterrupted()`返回`true`，第二种情况是因为捕获到了
`InterruptedException`。

确实，`volatile`关键字在Java中用于解决共享变量在线程间的可见性问题。下面是对`volatile`关键字的详细解释，包括其工作原理、适用场景以及与`synchronized`的区别。

### 什么是`volatile`关键字？

`volatile`关键字是一个特殊的修饰符，可以应用于变量上。当一个变量被声明为`volatile`时，它具有以下特性：

1. **可见性**：确保一个线程对`volatile`变量的修改对其他线程是立即可见的。
2. **禁止指令重排序**：防止编译器和处理器对`volatile`变量的读写操作进行重排序。

### 工作原理

#### 可见性

在多线程环境下，每个线程都有自己的工作内存（也称为线程栈），当线程访问一个变量时，通常是从自己的工作内存中读取。而工作内存中的数据是从主内存（也称为堆内存）中复制过来的。如果没有特殊措施，一个线程对共享变量的修改不会立即反映到其他线程的工作内存中。

`volatile`关键字通过确保对`volatile`变量的读写操作直接在主内存中进行，从而保证了变量的可见性。具体来说：

- 当一个线程修改了`volatile`变量的值时，这个修改会立即刷新到主内存。
- 当其他线程需要读取这个`volatile`变量时，它们会从主内存中读取最新的值，而不是从各自的工作内存中读取旧值。

#### 禁止指令重排序

编译器和处理器为了优化性能，可能会对代码进行指令重排序。例如，编译器可能会将两个不相关的操作交换顺序，以提高指令流水线的效率。然而，这种重排序可能会导致多线程环境下出现不可预测的行为。

`volatile`关键字通过禁止指令重排序来保证以下两点：

- 对`volatile`变量的写操作不会被重排序到写操作之前。
- 对`volatile`变量的读操作不会被重排序到读操作之后。

这确保了对`volatile`变量的操作按照程序中指定的顺序进行，避免了由于重排序导致的不一致性问题。

### 适用场景

`volatile`关键字适用于以下场景：

1. **状态标志**：
    - 用于表示某个状态或标志位，例如线程是否应该继续运行。
    ```java
    volatile boolean running = true;
    ```

2. **单例模式**：
    - 在双重检查锁定（Double-Checked Locking）模式中，用于确保实例的可见性和一致性。
    ```java
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    ```

3. **配置参数**：
    - 用于存储配置参数，这些参数可能会在运行时被外部系统修改。
    ```java
    volatile int configValue;
    ```

### 与`synchronized`的区别

虽然`volatile`和`synchronized`都可以用于解决多线程环境下的并发问题，但它们的作用和使用场景有所不同：

1. **`volatile`**:
    - **可见性**：确保变量的修改对所有线程立即可见。
    - **原子性**：仅适用于单个变量的读写操作，不能保证复合操作的原子性。
    - **性能**：开销较小，适用于对性能要求较高的场景。
    - **适用场景**：适用于状态标志、配置参数等简单场景。

2. **`synchronized`**:
    - **可见性**：确保变量的修改对所有线程立即可见。
    - **原子性**：保证复合操作的原子性，可以确保多个操作作为一个整体被执行。
    - **性能**：开销较大，适用于对数据一致性要求较高的场景。
    - **适用场景**：适用于需要保证复合操作原子性的复杂场景。

### 示例代码

以下是一个简单的示例，展示了`volatile`关键字的使用：

```java
public class VolatileExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            int i = 0;
            while (running) {
                i++;
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Worker thread stopped.");
        });

        workerThread.start();

        Thread.sleep(2000); // 让workerThread运行2秒
        running = false; // 修改volatile变量
        System.out.println("Main thread set running to false.");
    }
}
```

在这个示例中，`running`变量被声明为`volatile`，确保主线程对`running`变量的修改能够立即对`workerThread`可见，从而使得`workerThread`能够及时停止运行。

### 总结

- **可见性**：`volatile`确保对变量的修改对所有线程立即可见。
- **禁止指令重排序**：`volatile`禁止对变量的读写操作进行重排序。
- **适用场景**：适用于状态标志、配置参数等简单场景。
- **与`synchronized`的区别**：`volatile`仅保证可见性和禁止重排序，不保证复合操作的原子性；`synchronized`保证可见性、原子性和复合操作的顺序性。

希望这些解释能帮助你更好地理解和使用`volatile`关键字。

 */
public class ThreadInterruptedExample {

}
