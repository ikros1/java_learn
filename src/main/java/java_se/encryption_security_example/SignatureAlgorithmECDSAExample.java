package java_se.encryption_security_example;

import java.security.*;
import java.util.Base64;

public class SignatureAlgorithmECDSAExample {
    public static void main(String[] args) {
        try {
            // 1. 生成ECDSA密钥对
            KeyPair keyPair = generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // 2. 要签名的数据
            String message = "Hello, World!";
            byte[] data = message.getBytes();

            // 3. 使用私钥创建ECDSA签名
            byte[] signatureBytes = signData(data, privateKey);
            String encodedSignature = Base64.getEncoder().encodeToString(signatureBytes);
            System.out.println("Signature: " + encodedSignature);

            // 4. 使用公钥验证ECDSA签名
            boolean isVerified = verifySignature(data, signatureBytes, publicKey);
            System.out.println("Signature verified: " + isVerified);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成ECDSA密钥对
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(256); // 使用256位的椭圆曲线参数集
        return keyGen.generateKeyPair();
    }

    // 使用私钥创建ECDSA签名
    public static byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    // 使用公钥验证ECDSA签名
    public static boolean verifySignature(byte[] data, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signatureBytes);
    }
}
