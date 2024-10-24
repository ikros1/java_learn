package java_se.java_common_tool_class_example.hex_format_exmaple;

import java.util.HexFormat;

public class HexFormatExample {
    public static void main(String[] args) throws InterruptedException {
        //在处理byte[]数组时，我们经常需要与十六进制字符串转换，自己写起来比较麻烦，用Java标准库提供的HexFormat则可以方便地帮我们转换。
        //
        //要将byte[]数组转换为十六进制字符串，可以用formatHex()方法：
        byte[] data = "Hello".getBytes();
        HexFormat hf = HexFormat.of();
        String hexData = hf.formatHex(data); // 48656c6c6f
        System.out.println(hexData);
        //如果要定制转换格式，则使用定制的HexFormat实例：
        //
        //// 分隔符为空格，添加前缀0x，大写字母:
        HexFormat hsf = HexFormat.ofDelimiter(" ").withPrefix("0x").withUpperCase();
        hsf.formatHex("Hello".getBytes()); // 0x48 0x65 0x6C 0x6C 0x6F
        //从十六进制字符串到byte[]数组转换，使用parseHex()方法：
        byte[] bs = HexFormat.of().parseHex("48656c6c6f");
    }
}
