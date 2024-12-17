package java_se.IO_example;
/*
从Java 7开始，提供了Files这个工具类，能极大地方便我们读写文件。

虽然Files是java.nio包里面的类，但他俩封装了很多读写文件的简单方法，例如，我们要把一个文件的全部内容读取为一个byte[]，可以这么写：

byte[] data = Files.readAllBytes(Path.of("/path/to/file.txt"));
如果是文本文件，可以把一个文件的全部内容读取为String：

// 默认使用UTF-8编码读取:
String content1 = Files.readString(Path.of("/path/to/file.txt"));
// 可指定编码:
String content2 = Files.readString(Path.of("/path", "to", "file.txt"), StandardCharsets.ISO_8859_1);
// 按行读取并返回每行内容:
List<String> lines = Files.readAllLines(Path.of("/path/to/file.txt"));
写入文件也非常方便：

// 写入二进制文件:
byte[] data = ...
Files.write(Path.of("/path/to/file.txt"), data);
// 写入文本并指定编码:
Files.writeString(Path.of("/path/to/file.txt"), "文本内容...", StandardCharsets.ISO_8859_1);
// 按行写入文本:
List<String> lines = ...
Files.write(Path.of("/path/to/file.txt"), lines);
此外，Files工具类还有copy()、delete()、exists()、move()等快捷方法操作文件和目录。

最后需要特别注意的是，Files提供的读写方法，受内存限制，只能读写小文件，例如配置文件等，不可一次读入几个G的大文件。读写大型文件仍然要使用文件流，每次只读写一部分文件内容。

小结
对于简单的小文件读写操作，可以使用Files工具类简化代码。
  `java.nio.file.Files` 类是 Java NIO（New Input/Output）库的一部分，提供了许多用于文件操作的静态方法。以下是一些常见的用法示例：

### 1. 创建文件和目录

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        Path dirPath = Paths.get("exampleDir");

        try {
            // 创建文件
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
                System.out.println("文件创建成功: " + filePath);
            }

            // 创建目录
            if (Files.notExists(dirPath)) {
                Files.createDirectory(dirPath);
                System.out.println("目录创建成功: " + dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2. 删除文件和目录

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        Path dirPath = Paths.get("exampleDir");

        try {
            // 删除文件
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                System.out.println("文件删除成功: " + filePath);
            }

            // 删除目录
            if (Files.exists(dirPath)) {
                Files.delete(dirPath);
                System.out.println("目录删除成功: " + dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 3. 读取文件内容

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");

        try {
            // 读取文件内容为字符串列表
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 4. 写入文件内容

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");

        try {
            // 写入多行字符串到文件
            List<String> lines = Arrays.asList("Hello, World!", "This is a test.");
            Files.write(filePath, lines);

            System.out.println("文件写入成功: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 5. 复制和移动文件

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("example.txt");
        Path destPath = Paths.get("example_copy.txt");

        try {
            // 复制文件
            Files.copy(sourcePath, destPath);
            System.out.println("文件复制成功: " + sourcePath + " 到 " + destPath);

            // 移动文件
            Path movedPath = Files.move(destPath, Paths.get("moved_example.txt"));
            System.out.println("文件移动成功: " + destPath + " 到 " + movedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

这些示例展示了 `java.nio.file.Files` 类的一些基本用法，包括创建、删除、读取、写入、复制和移动文件和目录。通过这些方法，可以方便地进行各种文件操作。
 */
public class FilesExample {

}
