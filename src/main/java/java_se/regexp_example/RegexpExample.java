package java_se.regexp_example;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpExample {

    public static void main(String[] args) {
        //       ^、$：开始和结束
        //
        //       [abc]：匹配abc中任意字符
        //
        //       [ ^abc]：除了abc的任意字符
        //
        //       [a-z]：a到z之间的字符
        //
        //       [a-zA-Z0-9]：a到z、A到Z、0到9之间的任意字符
        //
        //       \d  ：数字字符，等效于[0-9]
        //
        //        \w ：单词字符，等效于[ a-zA-Z0-9_ ]
        //
        //        \s  ：空白字符，如空格，制表符，换行，回车等。
        //
        //        \D ：非数字字符
        //
        //       \W：非单词字符
        //
        //       \S ：非空白字符
        //
        //        ?：0到1个
        //
        //        *：0到多个
        //
        //        +：1到多个
        //
        //        .：任意字符
        //
        //        |：或者
        //
        //        \：转译
        //
        //          X{n}：n个X
        //
        //          X{n,}：n到多个X
        //
        //          X{n,m}：n到m个X
        //
        //       ^：非
        //
        //                  ()：分组

        // 验证是否是整数
        System.out.println("验证是否为整数");
        String num_str = "22";
        boolean ok = num_str.matches("^\\d+$");
        System.out.println(ok);

        // 验证是否是小数  12.12
        System.out.println("验证是否为小数");
        String float_str = "12.12";
        ok = float_str.matches("^\\d+\\.\\d+$");
        System.out.println(ok);

        // 验证两位小数
        System.out.println("验证两位小数");
        ok = float_str.matches("^\\d+\\.\\d{2}$");
        System.out.println(ok);

        // 验证整数或者小数
        System.out.println("验证整数或者小数");
        ok = num_str.matches("^(\\d+)|(\\d+\\.\\d+)$");
        System.out.println(ok);
        ok = float_str.matches("^\\d+(\\.\\d+)?$");
        System.out.println(ok);

        //验证大多数汉字：\u4E00  \u9FA5
        System.out.println("验证为汉字");
        String str = "中国";
        ok = str.matches("^[\u4E00-\u9FA5]+$");
        System.out.println(ok);

        //匹配替换字符
        System.out.println("匹配替换字符");
        str = "abc123dfa456sdf";
        str = str.replace("123", "-");
        System.out.println(str);
        str = str.replaceAll("\\d+", "-");
        System.out.println(str);

        //分割字符到数组
        System.out.println("分割字符到数组");
        str = "Java.Python.PHP";
        String[] ss = str.split("\\.");
        System.out.println(Arrays.toString(ss));


		// 模式对象，设置正则表达式
        System.out.println("模式对象");
        str = "Java123Python456";
		Pattern p = Pattern.compile("[a-zA-Z]+");
		// 匹配对象，匹配字符串
		Matcher m = p.matcher(str);
		// 判断有没有找到匹配上的字符串
		while (m.find()) {
			// 匹配上的字符串
			System.out.println(m.group());
		}

        /*
         * name		tom
         * salary	18000
         */
        str = "nam@e=to%m@;salary=18000;";
        Pattern p2 = Pattern.compile("([^=]+)=([^;]+);");
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            // m2.group(组索引)，从1开始
            System.out.println(m2.group(1) + "\t" + m2.group(2));
        }
    }
}
