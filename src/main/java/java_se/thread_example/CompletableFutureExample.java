package java_se.thread_example;
/*
使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。

从Java 8开始引入了CompletableFuture，它针对Future做了改进，可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。

我们以获取股票价格为例，看看如何使用CompletableFuture：

// CompletableFuture
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
创建一个CompletableFuture是通过CompletableFuture.supplyAsync()实现的，它需要一个实现了Supplier接口的对象：

public interface Supplier<T> {
    T get();
}
这里我们用lambda语法简化了一下，直接传入Main::fetchPrice，因为Main.fetchPrice()静态方法的签名符合Supplier接口的定义（除了方法名外）。

紧接着，CompletableFuture已经被提交给默认的线程池执行了，我们需要定义的是CompletableFuture完成时和异常时需要回调的实例。完成时，CompletableFuture会调用Consumer对象：

public interface Consumer<T> {
    void accept(T t);
}
异常时，CompletableFuture会调用Function对象：

public interface Function<T, R> {
    R apply(T t);
}
这里我们都用lambda语法简化了代码。

可见CompletableFuture的优点是：

异步任务结束时，会自动回调某个对象的方法；
异步任务出错时，会自动回调某个对象的方法；
主线程设置好回调后，不再关心异步任务的执行。
如果只是实现了异步回调机制，我们还看不出CompletableFuture相比Future的优势。CompletableFuture更强大的功能是，多个CompletableFuture可以串行执行，例如，定义两个CompletableFuture，第一个CompletableFuture根据证券名称查询证券代码，第二个CompletableFuture根据证券代码查询证券价格，这两个CompletableFuture实现串行操作如下：

// CompletableFuture
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
除了串行执行外，多个CompletableFuture还可以并行执行。例如，我们考虑这样的场景：

同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：

// CompletableFuture
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
上述逻辑实现的异步查询规则实际上是：

┌─────────────┐ ┌─────────────┐
│ Query Code  │ │ Query Code  │
│  from sina  │ │  from 163   │
└─────────────┘ └─────────────┘
       │               │
       └───────┬───────┘
               ▼
        ┌─────────────┐
        │    anyOf    │
        └─────────────┘
               │
       ┌───────┴────────┐
       ▼                ▼
┌─────────────┐  ┌─────────────┐
│ Query Price │  │ Query Price │
│  from sina  │  │  from 163   │
└─────────────┘  └─────────────┘
       │                │
       └────────┬───────┘
                ▼
         ┌─────────────┐
         │    anyOf    │
         └─────────────┘
                │
                ▼
         ┌─────────────┐
         │Display Price│
         └─────────────┘
除了anyOf()可以实现“任意个CompletableFuture只要一个成功”，allOf()可以实现“所有CompletableFuture都必须成功”，这些组合操作可以实现非常复杂的异步流程控制。

最后我们注意CompletableFuture的命名规则：

xxx()：表示该方法将继续在已有的线程中执行；
xxxAsync()：表示将异步在线程池中执行。
你的理解基本上是正确的，但有一些细节需要澄清。让我们详细解释一下`thenAccept()`和`Thread.sleep(200)`的作用及其背后的原理。

### `thenAccept()` 方法

```java
cfFetch.thenAccept((result) -> {
    System.out.println("price: " + result);
});
```

- **`thenAccept()`**：这个方法用于在当前`CompletableFuture`完成后执行一个消费操作。它接收一个`Consumer<T>`函数式接口作为参数，该接口的`accept(T t)`方法会被调用来处理前一个阶段的结果。在这个例子中，一旦`cfFetch`完成（即从任意一个网站获取到价格），就会调用提供的lambda表达式来打印价格。

- **非阻塞特性**：`thenAccept()`不会阻塞主线程。它只是注册了一个回调函数，当`cfFetch`完成时，这个回调函数会在某个线程（可能是ForkJoinPool中的工作线程，也可能是自定义的线程池中的线程）上执行。这意味着主线程可以继续执行后续的代码，而不需要等待`thenAccept()`中的操作完成。

### `Thread.sleep(200)`

```java
Thread.sleep(200);
```

- **防止主线程立即退出**：默认情况下，Java程序会在所有非守护线程（包括主线程）执行完毕后退出。如果主线程立即退出，而异步任务还没有完成，这些异步任务所在的线程池可能会被关闭，导致异步任务无法正常完成。

- **阻塞主线程**：`Thread.sleep(200)`会阻塞主线程200毫秒，这给了异步任务足够的时间来完成。这样可以确保主线程不会在异步任务完成之前退出，从而避免异步任务被中断。

### 完整流程

1. **创建异步任务**：
   - `cfQueryFromSina` 和 `cfQueryFrom163` 分别从两个不同的网站异步查询股票代码。

2. **合并查询任务**：
   - `cfQuery` 使用 `anyOf()` 方法合并两个查询任务，只要其中一个任务完成，`cfQuery` 就会完成。

3. **根据查询结果继续执行异步操作**：
   - `cfFetchFromSina` 和 `cfFetchFrom163` 根据 `cfQuery` 的结果（即股票代码）异步查询价格。

4. **合并获取价格的任务**：
   - `cfFetch` 使用 `anyOf()` 方法合并两个获取价格的任务，只要其中一个任务完成，`cfFetch` 就会完成。

5. **处理最终结果**：
   - `cfFetch.thenAccept()` 注册了一个回调函数，在 `cfFetch` 完成时打印价格。

6. **防止主线程立即退出**：
   - `Thread.sleep(200)` 阻塞主线程200毫秒，确保异步任务有足够的时间完成。

通过这种方式，程序能够正确地处理异步操作，并且不会因为主线程过早退出而导致异步任务被中断。
确实，`CompletableFuture` 提供了多种组合操作来实现复杂的异步流程控制。除了 `anyOf()` 和 `allOf()`，还有许多其他方法可以帮助你构建灵活且高效的异步任务链。下面是对这些方法的详细解释，特别是关于命名规则的部分。

### 组合操作

#### `anyOf()`
- **作用**：返回一个新的 `CompletableFuture`，当任意一个输入的 `CompletableFuture` 完成时，这个新的 `CompletableFuture` 也会完成。
- **示例**：
  ```java
  CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
  ```

#### `allOf()`
- **作用**：返回一个新的 `CompletableFuture`，当所有输入的 `CompletableFuture` 都完成时，这个新的 `CompletableFuture` 才会完成。
- **示例**：
  ```java
  CompletableFuture<Void> cfAll = CompletableFuture.allOf(cfQueryFromSina, cfQueryFrom163);
  ```

### 命名规则

`CompletableFuture` 的方法命名规则非常一致，主要分为两类：

1. **同步执行方法 (`xxx()`)**：
   - 这些方法会在当前线程中继续执行后续操作。
   - **示例**：
     ```java
     CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
     CompletableFuture<Integer> cfLength = cf.thenApply(s -> s.length());
     ```
     - `thenApply()` 会在 `cf` 完成后在同一线程中执行 `s -> s.length()` 操作。

2. **异步执行方法 (`xxxAsync()`)**：
   - 这些方法会在 `ForkJoinPool.commonPool()` 或者指定的 `Executor` 中异步执行后续操作。
   - **示例**：
     ```java
     CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
     CompletableFuture<Integer> cfLength = cf.thenApplyAsync(s -> s.length());
     ```
     - `thenApplyAsync()` 会在 `cf` 完成后在 `ForkJoinPool.commonPool()` 中的一个工作线程上执行 `s -> s.length()` 操作。

### 其他常用方法

#### `thenRun(Runnable action)`
- **作用**：在当前 `CompletableFuture` 完成后执行一个 `Runnable` 任务，不接收前一个阶段的结果，也不产生新的结果。
- **示例**：
  ```java
  cfFetch.thenRun(() -> System.out.println("Task completed"));
  ```

#### `thenRunAsync(Runnable action)`
- **作用**：在当前 `CompletableFuture` 完成后异步执行一个 `Runnable` 任务。
- **示例**：
  ```java
  cfFetch.thenRunAsync(() -> System.out.println("Task completed"));
  ```

#### `thenCompose(Function<? super T, ? extends CompletionStage<U>> fn)`
- **作用**：在当前 `CompletableFuture` 完成后，将结果传递给一个新的 `CompletableFuture`，并且返回这个新的 `CompletableFuture`。
- **示例**：
  ```java
  CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
  CompletableFuture<Integer> cfLength = cf.thenCompose(s -> CompletableFuture.supplyAsync(() -> s.length()));
  ```

#### `thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn)`
- **作用**：与 `thenCompose` 类似，但在 `ForkJoinPool.commonPool()` 或指定的 `Executor` 中异步执行。
- **示例**：
  ```java
  CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
  CompletableFuture<Integer> cfLength = cf.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s.length()));
  ```

#### `thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn)`
- **作用**：在当前 `CompletableFuture` 和另一个 `CompletionStage` 都完成后，将它们的结果传递给一个 `BiFunction`，并返回一个新的 `CompletableFuture`。
- **示例**：
  ```java
  CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
  CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 123);
  CompletableFuture<String> cfCombined = cf1.thenCombine(cf2, (s, i) -> s + " " + i);
  ```

#### `thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn)`
- **作用**：与 `thenCombine` 类似，但在 `ForkJoinPool.commonPool()` 或指定的 `Executor` 中异步执行。
- **示例**：
  ```java
  CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello");
  CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 123);
  CompletableFuture<String> cfCombined = cf1.thenCombineAsync(cf2, (s, i) -> s + " " + i);
  ```

### 自定义线程池

有时你可能希望使用自定义的线程池来执行异步任务，可以通过 `xxxAsync()` 方法的重载版本来实现：

```java
Executor customExecutor = Executors.newFixedThreadPool(10);

CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello", customExecutor);
CompletableFuture<Integer> cfLength = cf.thenApplyAsync(s -> s.length(), customExecutor);
```

### 总结

- **同步方法 (`xxx()`)**：在当前线程中继续执行后续操作。
- **异步方法 (`xxxAsync()`)**：在 `ForkJoinPool.commonPool()` 或指定的 `Executor` 中异步执行后续操作。

这种命名规则使得 `CompletableFuture` 的方法非常直观，易于理解和使用。通过这些组合操作和命名规则，你可以构建复杂的异步流程控制，提高程序的性能和响应能力。
 */
public class CompletableFutureExample {

}
