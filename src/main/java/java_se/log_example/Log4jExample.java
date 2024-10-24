package java_se.log_example;

public class Log4jExample {
    public static void main(String[] args) {
//正常使用commonlogging就可以自动使用log4j
        /*
        需要进行配置
        否则提示未初始化
        C:\Users\ikaros\.jdks\openjdk-22.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\lib\idea_rt.jar=57373:C:\Program Files\JetBrains\IntelliJ IDEA 2024.1.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\ikaros\Desktop\java_learn\target\classes;C:\Users\ikaros\.m2\repository\org\apache\commons\commons-lang3\3.17.0\commons-lang3-3.17.0.jar;C:\Users\ikaros\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\ikaros\.m2\repository\log4j\log4j\1.2.17\log4j-1.2.17.jar java_se.log_example.CommonsLoggingExample
log4j:WARN No appenders could be found for logger (java_se.log_example.CommonsLoggingExample).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
/*
使用教程：https://www.cnblogs.com/hailexuexi/p/14838073.html
        */
    }
}
