package java_se.encryption_security_example;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;

public class HashExample {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchProviderException {
        System.out.println("Hash Example");
        System.out.println("hello".hashCode());
        System.out.println("AaAaAa".hashCode());
        System.out.println("BBAaBB".hashCode());

        String input = "Hello, World!";

        // MD5
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md5Digest.digest(input.getBytes());
        System.out.println("MD5: " + bytesToHex(md5Bytes));

        // SHA-1
        MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
        byte[] sha1Bytes = sha1Digest.digest(input.getBytes());
        System.out.println("SHA-1: " + bytesToHex(sha1Bytes));

        // RipeMD-160 (需要额外添加BouncyCastle库支持)
        // 添加依赖后：
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest ripemd160Digest = MessageDigest.getInstance("RIPEMD160", "BC");
        byte[] ripemd160Bytes = ripemd160Digest.digest(input.getBytes());
        System.out.println("RipeMD-160: " + bytesToHex(ripemd160Bytes));

        // SHA-256
        MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
        byte[] sha256Bytes = sha256Digest.digest(input.getBytes());
        System.out.println("SHA-256: " + bytesToHex(sha256Bytes));

        // SHA-512
        MessageDigest sha512Digest = MessageDigest.getInstance("SHA-512");
        byte[] sha512Bytes = sha512Digest.digest(input.getBytes());
        System.out.println("SHA-512: " + bytesToHex(sha512Bytes));

        String filePath = "README.md";

        // 使用DigestInputStream对文件进行哈希计算
        FileInputStream fis = new FileInputStream(filePath);
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // 可以替换为其他算法
        DigestInputStream dis = new DigestInputStream(fis, md);

        // 读取整个文件（这里只是简单地遍历，实际应用中可能不需要读取内容）
        while (dis.read() != -1) {}

        byte[] fileHashBytes = md.digest();
        System.out.println("SHA-256 of the file: " + bytesToHex(fileHashBytes));

        dis.close();
        fis.close();
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
