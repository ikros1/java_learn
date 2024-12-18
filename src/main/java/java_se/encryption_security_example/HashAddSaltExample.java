package java_se.encryption_security_example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashAddSaltExample {

    // 生成一个随机的盐
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 盐的长度可以调整
        random.nextBytes(salt);
        return salt;
    }

    // 使用盐和原始数据计算哈希值
    public static byte[] hashWithSalt(byte[] salt, String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return hash;
    }

    // 将字节数组转换为Base64编码的字符串
    public static String bytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    // 将Base64编码的字符串转换为字节数组
    public static byte[] base64ToBytes(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    public static void main(String[] args) {
        try {
            String password = "mySecretPassword";

            // 生成盐
            byte[] salt = generateSalt();
            System.out.println("Generated Salt: " + bytesToBase64(salt));

            // 计算哈希值
            byte[] hashedPassword = hashWithSalt(salt, password);
            System.out.println("Hashed Password: " + bytesToBase64(hashedPassword));

            // 存储盐和哈希值（这里假设存储为Base64编码的字符串）
            String storedSalt = bytesToBase64(salt);
            String storedHash = bytesToBase64(hashedPassword);

            // 验证过程
            String inputPassword = "mySecretPassword";
            byte[] inputSalt = base64ToBytes(storedSalt);
            byte[] inputHashedPassword = hashWithSalt(inputSalt, inputPassword);

            if (bytesToBase64(inputHashedPassword).equals(storedHash)) {
                System.out.println("Password verification successful!");
            } else {
                System.out.println("Password verification failed!");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}