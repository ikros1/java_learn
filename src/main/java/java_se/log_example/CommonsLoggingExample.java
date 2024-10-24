package java_se.log_example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingExample {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLoggingExample.class);
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug");
        //Commons Logging定义了6个日志级别：
        //
        //FATAL
        //ERROR
        //WARNING
        //INFO
        //DEBUG
        //TRACE
        //默认级别是INFO。
        /*
        使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量：

// 在静态方法中引用Log:
public class Main {
    static final Log log = LogFactory.getLog(Main.class);

    static void foo() {
        log.info("foo");
    }
}
在实例方法中引用Log，通常定义一个实例变量：

// 在实例方法中引用Log:
public class Person {
    protected final Log log = LogFactory.getLog(getClass());

    void foo() {
        log.info("foo");
    }
}
此外，Commons Logging的日志方法，例如info()，除了标准的info(String)外，还提供了一个非常有用的重载方法：info(String, Throwable)，这使得记录异常更加简单：

try {
    ...
} catch (Exception e) {
    log.error("got exception!", e);
}
         */
    }
}
