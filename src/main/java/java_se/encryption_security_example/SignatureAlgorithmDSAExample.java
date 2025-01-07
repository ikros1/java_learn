package java_se.encryption_security_example;

import java.security.*;
import java.util.Base64;

public class SignatureAlgorithmDSAExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // 1. 生成DSA密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048); // 可以指定密钥长度，例如2048位
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // 2. 要签名的数据
        String dataToSign = "Hello, DSA!";
        byte[] dataBytes = dataToSign.getBytes();

        // 3. 使用私钥创建并初始化Signature对象
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);

        // 4. 更新要签名的数据
        signature.update(dataBytes);

        // 5. 生成签名
        byte[] signedData = signature.sign();
        System.out.println("Signed Data: " + Base64.getEncoder().encodeToString(signedData));

        // 6. 验证签名：重新初始化Signature对象以验证模式，并更新数据
        signature.initVerify(publicKey);
        signature.update(dataBytes);

        // 7. 验证签名是否正确
        boolean isVerified = signature.verify(signedData);
        System.out.println("Signature Verified: " + isVerified);
    }
}
