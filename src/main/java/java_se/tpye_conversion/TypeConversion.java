package java_se.basic_input_output;

public class TypeConversion {
    public static void main(String[] args) {
        // 字符串转基本类型
        String str = "13.33";
        double dou = Double.parseDouble(str);
        System.out.println(dou);

        String str2 = "13";
        int num = Integer.parseInt(str2);
        System.out.println(num);

        Boolean boolean1 = Boolean.valueOf("true");
        Boolean boolean2 = Boolean.parseBoolean("true");
        Boolean boolean3 = Boolean.valueOf("false");
        Boolean boolean4 = Boolean.parseBoolean("false");
        Boolean boolean5 = Boolean.valueOf("tRue");
        Boolean boolean6 = Boolean.valueOf("trues");
        System.out.println(boolean1);
        System.out.println(boolean2);
        System.out.println(boolean3);
        System.out.println(boolean4);
        System.out.println(boolean5);
        System.out.println(boolean6);

        // 基本类型转字符串
        int num2 = 9;
        Boolean boolean7 = true;
        String str4 = String.valueOf(num2);
        String str5 = num2+"";
        String str6 = String.valueOf(boolean7);
        String str7 = boolean7+"";
        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);

    }
}
