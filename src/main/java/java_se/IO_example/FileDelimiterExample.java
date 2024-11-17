package java_se.IO_example;
import java.io.File;
/*
在Java中，File类提供了一个静态属性separator，该属性会根据当前操作系统的文件路径分隔符来进行设置。因此，开发者可以使用File.separator来构建跨平台的文件路径。这种方法能够确保在不同操作系统上都能正确地构建出文件路径。

示例代码如下：
 */
public class FileDelimiterExample {
    public static void main(String[] args) {
        // 获取当前操作系统的路径分隔符
        String separator = File.separator;

        // 使用分隔符构建文件路径
        String path = "usr" + separator + "local" + separator + "bin";

        // 输出构建的路径
        System.out.println("构建的路径为: " + path);
    }
}