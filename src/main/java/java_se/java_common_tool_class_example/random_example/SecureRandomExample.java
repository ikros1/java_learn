package java_se.java_common_tool_class_example.random_example;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class SecureRandomExample {
    public static void main(String[] args) {
        //有伪随机数，就有真随机数。实际上真正的真随机数只能通过量子力学原理来获取，
        // 而我们想要的是一个不可预测的安全的随机数，SecureRandom就是用来创建安全的随机数的：
        //SecureRandom无法指定种子，它使用RNG（random number generator）算法。
        // JDK的SecureRandom实际上有多种不同的底层实现，
        // 有的使用安全随机种子加上伪随机数算法来产生安全的随机数，
        // 有的使用真正的随机数生成器。实际使用的时候，可以优先获取高强度的安全随机数生成器
        // ，如果没有提供，再使用普通等级的安全随机数生成器：
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}
