package java_se.string_method_example;

import java.util.Arrays;

public class StringClassExample {
    public static void main(String[] args) {
        //Character
        System.out.println("Character------------------");
        char c = '\n';
        System.out.println(c);
        //判断是否为整数
        System.out.println(c>=0&&c<=9);
        System.out.println(Character.isDigit(c));
        //判断是否为小写字母
        System.out.println(c>='a'&&c<='z');
        System.out.println(Character.isLowerCase(c));
        //判断是否为大写字母
        System.out.println(c>='A'&&c<='Z');
        System.out.println(Character.isUpperCase(c));
        //判断是否为字母或数字
        System.out.println(c>='A'&&c<='Z'||c>='a'&&c<='z'||c>='0'&&c<='9');
        System.out.println(Character.isLetterOrDigit(c));
        //判断是否为字母
        System.out.println(c>='A'&&c<='Z'||c>='a'&&c<='z');
        System.out.println(Character.isLetter(c));
        //判断是否为空白字符
        System.out.println(Character.isWhitespace(c));

        //String
        System.out.println("String-------------------");
        String str2 = "abcdefga";
        System.out.println(str2.charAt(0));

        String s1 = "abc";
        String s2 = "ABC";
        //字符串比较 正数第一个大 负数第二个大 0 相等
        System.out.println(s1.compareTo(s2));
        //不区分大小写比较
        System.out.println(s1.compareToIgnoreCase(s2));
        //判断是否存在
        System.out.println(str2.contains("df"));
        //判断是否以某字符串开头
        System.out.println(str2.startsWith("abc"));
        //判断是否以某个字符串结尾
        System.out.println(str2.endsWith("def"));
        //比较字符串是否相等
        System.out.println(str2.equals("abcdefg"));
        //不区分大小的相等
        System.out.println(s1.equalsIgnoreCase(s2));
        //将字符数组转换成字节数组
        byte[] arr = str2.getBytes();
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        //依据元素查找字符 从左到右找第一个 找不到-1
        System.out.println(str2.indexOf("ad"));
        //依据元素查找字符，从左往右找最后一个
        System.out.println(str2.lastIndexOf("ad"));

        //判断是否为空字符串
        System.out.println(str2.isEmpty());
        System.out.println(str2.length()== 0 );
        //字符串替换
        System.out.println(str2.replace('a','b'));

        //字符串分割
        String strArr = "tom,amy,john";
        String[] sArr = strArr.split(",");
        System.out.println(sArr.length);
        System.out.println(Arrays.toString(sArr));
        /*
         * 	截取子串：substring(开始位置，结束位置)   不包含结束位置   含头不含尾
         *  substring(开始位置)：从开始位置截取到最后
         */
        String str4 = "abcdefg";
        System.out.println(str4.substring(1));
        System.out.println(str4.substring(1,3));

        //转换大小写
        System.out.println(str4.toUpperCase());
        System.out.println(str4.toLowerCase());

        //去掉两遍的空格
        String str5 = "   aaa    ";
        str5 = str5.trim();
        System.out.println(str5);
    }
}
