package java_se.thread_example;
/*
在执行多个任务的时候，使用Java标准库提供的线程池是非常方便的。我们提交的任务只需要实现Runnable接口，就可以让线程池去执行：

class Task implements Runnable {
    public String result;

    public void run() {
        this.result = longTimeCalculation();
    }
}
Runnable接口有个问题，它的方法没有返回值。如果任务需要一个返回结果，那么只能保存到变量，还要提供额外的方法读取，非常不便。所以，Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：

class Task implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation();
    }
}
并且Callable接口是一个泛型接口，可以返回指定类型的结果。

现在的问题是，如何获得异步执行的结果？

如果仔细看ExecutorService.submit()方法，可以看到，它返回了一个Future类型，一个Future类型的实例代表一个未来能获取结果的对象：

ExecutorService executor = Executors.newFixedThreadPool(4);
// 定义任务:
Callable<String> task = new Task();
// 提交任务并获得Future:
Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
String result = future.get(); // 可能阻塞
当我们提交一个Callable任务后，我们会同时获得一个Future对象，然后，我们在主线程某个时刻调用Future对象的get()方法，就可以获得异步执行的结果。在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。

一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：

get()：获取结果（可能会等待）
get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
cancel(boolean mayInterruptIfRunning)：取消当前任务；
isDone()：判断任务是否已完成。
 */

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 定义多个任务
        Callable<String> task1 = new Task("Task 1");
        Callable<String> task2 = new Task("Task 2");
        Callable<String> task3 = new Task("Task 3");

        // 提交任务并获得Future对象
        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        Future<String> future3 = executor.submit(task3);

        try {
            // 从Future对象获取异步执行的结果
            System.out.println("Result of Task 1: " + future1.get());
            System.out.println("Result of Task 2: " + future2.get());
            System.out.println("Result of Task 3: " + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class Task implements Callable<String> {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            // 模拟长时间计算
            Thread.sleep(2000);
            return "Result from " + name;
        }
    }
}