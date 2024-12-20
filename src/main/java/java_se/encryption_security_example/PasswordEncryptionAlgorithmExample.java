package java_se.encryption_security_example;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.util.Base64;
import java.util.HexFormat;

public class PasswordEncryptionAlgorithmExample {
    public static void main(String[] args) throws Exception {
        // 把BouncyCastle作为Provider添加到java.security:
        Security.addProvider(new BouncyCastleProvider());
        // 原文:
        String message = "Hello, world!";
        // 加密口令:
        String password = "hello12345";
        // 16 bytes随机Salt:
        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
        System.out.println(HexFormat.of().formatHex(salt));
        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(password, salt, data);
        System.out.println("encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(password, salt, encrypted);
        System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
    }
    // 加密:
    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    /*
    这段Java代码展示了如何使用BouncyCastle库进行基于密码的加密（Password-Based Encryption, PBE）算法来加密和解密数据。以下是对代码的详细解析：

### 导入库

```java
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.util.Base64;
import java.util.HexFormat;
```

- `org.bouncycastle.jce.provider.BouncyCastleProvider`：BouncyCastle是一个开源的Java加密库，提供了许多安全相关的算法实现。
- `javax.crypto.*`：包含了加密操作所需的类，如Cipher、SecretKey等。
- `javax.crypto.spec.PBEKeySpec` 和 `javax.crypto.spec.PBEParameterSpec`：用于指定PBE算法的具体参数。
- `java.security.*`：提供了安全相关的基础类，如SecureRandom。
- `java.util.Base64`：用于Base64编码/解码。
- `java.util.HexFormat`：用于十六进制格式化输出。

### 主函数

```java
public static void main(String[] args) throws Exception {
    Security.addProvider(new BouncyCastleProvider());
    String message = "Hello, world!";
    String password = "hello12345";
    byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
    System.out.println(HexFormat.of().formatHex(salt));
    byte[] data = message.getBytes("UTF-8");
    byte[] encrypted = encrypt(password, salt, data);
    System.out.println("encrypted: " + Base64.getEncoder().encodeToString(encrypted));
    byte[] decrypted = decrypt(password, salt, encrypted);
    System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
}
```

- **添加BouncyCastle Provider**：将BouncyCastle作为安全提供者添加到Java的安全框架中。
- **定义明文和密码**：设置要加密的消息以及用于加密的密码。
- **生成盐值（Salt）**：使用`SecureRandom`生成一个16字节的随机数作为盐值，盐值在密码加密过程中起到防止彩虹表攻击的作用。
- **打印盐值**：以十六进制格式输出生成的盐值。
- **加密操作**：调用`encrypt`方法对明文进行加密，并将加密后的字节数组转换为Base64编码格式输出。
- **解密操作**：调用`decrypt`方法对加密后的数据进行解密，并将解密后的字节数组转换回字符串形式输出。

### 加密与解密方法

```java
public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
    SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
    SecretKey skey = skeyFactory.generateSecret(keySpec);
    PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
    Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
    cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
    return cipher.doFinal(input);
}

public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
    PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
    SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
    SecretKey skey = skeyFactory.generateSecret(keySpec);
    PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
    Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
    cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
    return cipher.doFinal(input);
}
```

- **创建PBEKeySpec对象**：根据输入的密码创建一个`PBEKeySpec`对象，该对象用于生成密钥。
- **获取SecretKeyFactory实例**：通过指定算法名称获取一个`SecretKeyFactory`实例。
- **生成密钥**：使用`SecretKeyFactory`根据`PBEKeySpec`生成实际的密钥。
- **创建PBEParameterSpec对象**：结合盐值和迭代次数创建一个`PBEParameterSpec`对象，用于指定加密算法的参数。
- **初始化Cipher对象**：根据指定的加密模式（ENCRYPT_MODE或DECRYPT_MODE）、密钥和参数初始化`Cipher`对象。
- **执行加密或解密操作**：调用`doFinal`方法完成实际的加密或解密过程。

这段代码完整地展示了如何利用PBE算法配合AES加密标准对数据进行加解密处理，并且强调了使用随机盐值的重要性。
     */
}
