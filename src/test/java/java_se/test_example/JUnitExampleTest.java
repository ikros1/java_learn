package java_se.test_example;


import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class JUnitExampleTest {
    private static final Logger logger = Logger.getLogger(JUnitExampleTest.class);
    private JUnitExample example;

    @BeforeEach
    public void setUp() {
        BasicConfigurator.configure(); // Configure log4j
        example = new JUnitExample();
    }

    @AfterEach
    public void tearDown() {
        // Cleanup code if necessary
    }

    @Test
    public void testAdd() {
        int result = example.add(5, 3);
        assertEquals(8, result);
        logger.info("testAdd passed");
    }


    @Test
    public void testQueryDatabase() {
        String result = "";
        try {
            result = example.queryDatabase("2","all_exercises");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        assertFalse(result.isEmpty()); // Assuming there's a user with id=1 in your database
        assertEquals("JVM JRE JDK",result.toString());
        logger.info("testQueryDatabase passed");
    }

    @Test
    public void testQueryDatabaseException() {

        assertThrows(SQLException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String result = example.queryDatabase("1","all_e");
            }
        });
        logger.info("testQueryDatabaseException passed");
    }

    @Disabled
    @Test
    public void testReadFile() throws IOException {
        String content = example.readFile("test_read.txt");
        assertEquals("Hello, World!", content);
        logger.info("testReadFile passed");
    }

    @Test
    public void testWriteFile() throws IOException {
        String filePath = "test_write.txt";
        String contentToWrite = "This is a test.";
        example.writeFile(filePath, contentToWrite);
        String writtenContent = example.readFile(filePath);
        assertEquals(contentToWrite, writtenContent);
        logger.info("testWriteFile passed");
    }

    @Test
    public void testDeleteFile() throws IOException {
        AtomicReference<String> filePath = new AtomicReference<>("test_write.txt");
        example.deleteFile(filePath.get());
        filePath.set("test_read.txt");
        example.deleteFile(filePath.get());
        assertThrows(IOException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String filePath = "test_write.txt";
                String writtenContent = example.readFile(filePath);
            }
        });
        assertThrows(IOException.class, () ->{
                filePath.set("test_read.txt");;
                String writtenContent = example.readFile(filePath.get());
            }
        );

        logger.info("testDeleteFile passed");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void  testOnWindows(){
        logger.info("test on windows");
    }
    /*
    我们来看一些常用的条件测试：

不在Windows平台执行的测试，可以加上@DisabledOnOs(OS.WINDOWS)：

@Test
@DisabledOnOs(OS.WINDOWS)
void testOnNonWindowsOs() {
    // TODO: this test is disabled on windows
}
只能在Java 9或更高版本执行的测试，可以加上@DisabledOnJre(JRE.JAVA_8)：

@Test
@DisabledOnJre(JRE.JAVA_8)
void testOnJava9OrAbove() {
    // TODO: this test is disabled on java 8
}
只能在64位操作系统上执行的测试，可以用@EnabledIfSystemProperty判断：

@Test
@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
void testOnlyOn64bitSystem() {
    // TODO: this test is only run on 64 bit system
}
需要传入环境变量DEBUG=true才能执行的测试，可以用@EnabledIfEnvironmentVariable：

@Test
@EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true")
void testOnlyOnDebugMode() {
    // TODO: this test is only run on DEBUG=true
}
     */
}