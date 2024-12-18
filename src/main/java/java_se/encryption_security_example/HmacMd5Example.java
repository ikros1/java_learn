package java_se.encryption_security_example;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.HexFormat;

public class HmacMd5Example {
    public static void main(String[] args) throws Exception {
        //生成秘钥加密
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        String skey_Hex = HexFormat.of().formatHex(skey);
        System.out.println(skey_Hex);
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(HexFormat.of().formatHex(result));
        //从字符串恢复秘钥
        byte[] hkey = HexFormat.of().parseHex(skey_Hex);
        key = new SecretKeySpec(hkey, "HmacMD5");
        mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        result = mac.doFinal();
        System.out.println(HexFormat.of().formatHex(result)); // 4af40be7864efaae1473a4c601b650ae
    }
}
/*
 这段代码展示了如何使用Java的`javax.crypto`包来生成一个HMAC-MD5密钥，并使用该密钥对字符串"HelloWorld"进行哈希运算。下面是对代码的详细解释：

1. **生成HMAC-MD5密钥**：
    ```java
    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
    SecretKey key = keyGen.generateKey();
    ```
    - `KeyGenerator.getInstance("HmacMD5")`：获取一个用于生成HMAC-MD5密钥的`KeyGenerator`实例。
    - `keyGen.generateKey()`：生成一个HMAC-MD5密钥。

2. **打印生成的密钥**：
    ```java
    byte[] skey = key.getEncoded();
    System.out.println(HexFormat.of().formatHex(skey));
    ```
    - `key.getEncoded()`：获取密钥的字节数组表示。
    - `HexFormat.of().formatHex(skey)`：将字节数组转换为十六进制字符串格式，并打印出来。

3. **初始化和使用Mac对象进行哈希运算**：
    ```java
    Mac mac = Mac.getInstance("HmacMD5");
    mac.init(key);
    mac.update("HelloWorld".getBytes("UTF-8"));
    byte[] result = mac.doFinal();
    System.out.println(HexFormat.of().formatHex(result));
    ```
    - `Mac.getInstance("HmacMD5")`：获取一个用于执行HMAC-MD5算法的`Mac`实例。
    - `mac.init(key)`：用之前生成的HMAC-MD5密钥初始化`Mac`对象。
    - `mac.update("HelloWorld".getBytes("UTF-8"))`：将字符串"HelloWorld"转换为字节数组，并更新到`Mac`对象中。
    - `mac.doFinal()`：完成哈希运算，返回结果的字节数组。
    - `HexFormat.of().formatHex(result)`：将哈希结果的字节数组转换为十六进制字符串格式，并打印出来。

### 完整代码示例

```java
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacMD5Example {
    public static void main(String[] args) {
        try {
            // 生成HMAC-MD5密钥
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
            SecretKey key = keyGen.generateKey();

            // 打印生成的密钥
            byte[] skey = key.getEncoded();
            System.out.println("Generated Key (Hex): " + HexFormat.of().formatHex(skey));

            // 初始化和使用Mac对象进行哈希运算
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(key);
            mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
            byte[] result = mac.doFinal();
            System.out.println("HMAC-MD5 Result (Hex): " + HexFormat.of().formatHex(result));

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
```

### 注意事项

- `HexFormat`类在Java 17及以上版本中可用。如果你使用的是较早版本的Java，可以使用其他方法（如Apache Commons Codec库）来将字节数组转换为十六进制字符串。
- 确保你的项目中包含了必要的依赖项，特别是如果你使用的是第三方库来处理十六进制格式化。

通过这段代码，你可以生成一个HMAC-MD5密钥，并使用该密钥对任意字符串进行哈希运算，从而得到一个安全的消息认证码（MAC）。
 */