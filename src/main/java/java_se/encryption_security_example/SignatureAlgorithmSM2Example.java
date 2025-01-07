package java_se.encryption_security_example;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class SignatureAlgorithmSM2Example {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) throws Exception {
        // 生成SM2密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", "BC");
        ECGenParameterSpec spec = new ECGenParameterSpec("sm2p256v1"); // 指定SM2曲线参数
        keyGen.initialize(spec);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 待签名的消息
        String message = "Hello, SM2!";
        byte[] data = message.getBytes();

        // 使用私钥签名
        Signature signature = Signature.getInstance("SM3withSM2", "BC");
        signature.initSign(privateKey);
        signature.update(data);
        byte[] signedData = signature.sign();

        System.out.println("Signed Data: " + Hex.toHexString(signedData));

        // 使用公钥验证签名
        signature.initVerify(publicKey);
        signature.update(data);
        boolean isVerified = signature.verify(signedData);

        if (isVerified) {
            System.out.println("Signature verified successfully.");
        } else {
            System.out.println("Signature verification failed.");
        }
    }
}
