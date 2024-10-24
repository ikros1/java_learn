package java_se.throwable_example;

public class ThrowExample2 {
    public static void main(String[] args) throws Exception {
        //如果在执行finally语句时抛出异常，那么，catch语句的异常还能否继续抛出？
        //// exception
        //public class Main {
        //    public static void main(String[] args) {
        //        try {
        //            Integer.parseInt("abc");
        //        } catch (Exception e) {
        //            System.out.println("catched");
        //            throw new RuntimeException(e);
        //        } finally {
        //            System.out.println("finally");
        //            throw new IllegalArgumentException();
        //        }
        //    }
        //}
        //执行上述代码，发现异常信息如下：
        //
        //catched
        //finally
        //Exception in thread "main" java.lang.IllegalArgumentException
        //    at Main.main(Main.java:11)
        //这说明finally抛出异常后，原来在catch中准备抛出的异常就“消失”了，
        // 因为只能抛出一个异常。没有被抛出的异常称为“被屏蔽”的
        // 异常（Suppressed Exception）。
        //
        //在极少数的情况下，我们需要获知所有的异常。如何保存所有的异常信息？
        // 方法是先用origin变量保存原始异常，然后调用Throwable.addSuppressed()，
        // 把原始异常添加进来，最后在finally抛出：
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }//通过Throwable.getSuppressed()可以获取所有的Suppressed Exception。

        //绝大多数情况下，在finally中不要抛出异常。因此，我们通常不需要关心Suppressed Exception。
    }
}
