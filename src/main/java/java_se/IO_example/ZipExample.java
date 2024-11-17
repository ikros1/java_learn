package java_se.IO_example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
ZipInputStream是一种FilterInputStream，它可以直接读取zip包的内容：

┌───────────────────┐
│    InputStream    │
└───────────────────┘
          ▲
          │
┌───────────────────┐
│ FilterInputStream │
└───────────────────┘
          ▲
          │
┌───────────────────┐
│InflaterInputStream│
└───────────────────┘
          ▲
          │
┌───────────────────┐
│  ZipInputStream   │
└───────────────────┘
          ▲
          │
┌───────────────────┐
│  JarInputStream   │
└───────────────────┘
另一个JarInputStream是从ZipInputStream派生，它增加的主要功能是直接读取jar文件里面的MANIFEST.MF文件。因为本质上jar包就是zip包，只是额外附加了一些固定的描述文件。

读取zip包
我们来看看ZipInputStream的基本用法。

我们要创建一个ZipInputStream，通常是传入一个FileInputStream作为数据源，然后，循环调用getNextEntry()，直到返回null，表示zip流结束。

一个ZipEntry表示一个压缩文件或目录，如果是压缩文件，我们就用read()方法不断读取，直到返回-1：

try (ZipInputStream zip = new ZipInputStream(new FileInputStream(...))) {
    ZipEntry entry = null;
    while ((entry = zip.getNextEntry()) != null) {
        String name = entry.getName();
        if (!entry.isDirectory()) {
            int n;
            while ((n = zip.read()) != -1) {
                ...
            }
        }
    }
}
写入zip包
ZipOutputStream是一种FilterOutputStream，它可以直接写入内容到zip包。我们要先创建一个ZipOutputStream，通常是包装一个FileOutputStream，然后，每写入一个文件前，先调用putNextEntry()，然后用write()写入byte[]数据，写入完毕后调用closeEntry()结束这个文件的打包。

try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(...))) {
    File[] files = ...
    for (File file : files) {
        zip.putNextEntry(new ZipEntry(file.getName()));
        zip.write(Files.readAllBytes(file.toPath()));
        zip.closeEntry();
    }
}
上面的代码没有考虑文件的目录结构。如果要实现目录层次结构，new ZipEntry(name)传入的name要用相对路径。

小结
ZipInputStream可以读取zip格式的流，ZipOutputStream可以把多份数据写入zip包；

配合FileInputStream和FileOutputStream就可以读写zip文件。
 */
public class ZipExample {
    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("C:\\Users\\ikaros\\Desktop\\java_learn\\src\\main\\resources\\OutputZip.zip"))) {
            File dir = new File(Paths.get("C:", "Users", "ikaros", "Desktop", "java_learn", "src", "main", "java", "java_se").toAbsolutePath().toString());

            // 检查目录是否存在并且是一个目录
            if (!dir.exists() || !dir.isDirectory()) {
                System.err.println("指定的目录不存在或不是一个目录: " + dir.getAbsolutePath());
                return;
            }

            List<File> javaFiles = getAllJavaFiles(dir);

            // 检查找到的 Java 文件列表是否为空
            if (javaFiles.isEmpty()) {
                System.err.println("未找到任何 .java 文件在目录: " + dir.getAbsolutePath());
                return;
            }

            for (File f : javaFiles) {
                String relativePath = Paths.get(dir.getAbsolutePath()).relativize(f.toPath()).toString();
                System.out.println("正在添加文件到 ZIP: " + relativePath);
                zos.putNextEntry(new ZipEntry(relativePath));
                zos.write(Files.readAllBytes(f.toPath()));
                zos.closeEntry();
            }

            System.out.println("ZIP 文件已成功创建: OutZip.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<File> getAllJavaFiles(File dir) {
        List<File> result = new ArrayList<>();
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    result.add(file);
                    System.out.println("找到 Java 文件: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    result.addAll(getAllJavaFiles(file));
                }
            }
        }

        return result;
    }
}