package java_se.encryption_security_example;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class EncodeExample {
    public static void main(String[] args) {
        //url编码
        System.out.println("url编码");
        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println(encoded);
        //url解码
        System.out.println("url解码");
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println(decoded);
        //base64编码
        System.out.println("base64编码");
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
        //base64解码
        System.out.println("base64解码");
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]
        //base64补全
        System.out.println("base64补全");
        byte[] input2 = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        String ib64encoded = Base64.getEncoder().encodeToString(input2);
        String ib64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input2);
        System.out.println(ib64encoded);
        System.out.println(ib64encoded2);
        byte[] output2 = Base64.getDecoder().decode(ib64encoded2);
        System.out.println(Arrays.toString(output2));
        //针对url的base64
        System.out.println("针对url的base64");
        input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(b64encoded);
        output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));



    }
}
