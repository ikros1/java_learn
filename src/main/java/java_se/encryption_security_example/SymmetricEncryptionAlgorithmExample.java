package java_se.encryption_security_example;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

public class SymmetricEncryptionAlgorithmExample {
    public static void main(String[] args) throws UnsupportedEncodingException, GeneralSecurityException {
        //AES加密CBC
        // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 128位密钥 = 16 bytes Key:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] key = sr.generateSeed(16);
        // 打印密钥的Base64编码形式以便查看
        String encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated 128-bit key (Base64): " + encodedKey);
        // 加密:
        byte[] data = message.getBytes(StandardCharsets.UTF_8);
        byte[] encrypted = encryptAesEcb(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decryptAesEcb(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
        //AES加密CBC
        message = "Hello, world!";
        System.out.println("Message: " + message);
        // 256位密钥 = 32 bytes Key:
        sr = SecureRandom.getInstanceStrong();
        key = sr.generateSeed(32);
        // 打印密钥的Base64编码形式以便查看
        encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated 256-bit key (Base64): " + encodedKey);
        // 加密:
        data = message.getBytes(StandardCharsets.UTF_8);
        encrypted = encryptAesCbc(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        decrypted = decryptAesCbc(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, StandardCharsets.UTF_8));
    }
    // 加密:
    public static byte[] encryptAesEcb(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decryptAesEcb(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }
    // 加密:
    public static byte[] encryptAesCbc(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    // 解密:
    public static byte[] decryptAesCbc(byte[] key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
}
/*
Java标准库提供的对称加密接口非常简单，使用时按以下步骤编写代码：

根据算法名称/工作模式/填充模式获取Cipher实例；
根据算法名称初始化一个SecretKey实例，密钥必须是指定长度；
使用SecretKey初始化Cipher实例，并设置加密或解密模式；
传入明文或密文，获得密文或明文。
 */
