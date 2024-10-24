package java_se.java_common_tool_class_example.math_example;

public class MathExample {
    public static void main(String[] args) {
        // 最大值
        System.out.println(Math.max(1, 2));
        // 最小值
        System.out.println(Math.min(1, 2));
        // 四舍五入
        System.out.println(Math.round(4.5));
        // 向上取整
        System.out.println(Math.ceil(4.1));
        // 向下取整
        System.out.println(Math.floor(-4.9));
        // 求幂
        System.out.println(Math.pow(10, 2));
        // 开平方
        System.out.println(Math.sqrt(16));
        // 开立方
        System.out.println(Math.cbrt(27));
        // 绝对值
        System.out.println(Math.abs(-8.5));
        // 常量
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //三角函数
        System.out.println(Math.sin(3.14)); // 0.00159...
        System.out.println(Math.cos(3.14)); // -0.9999...
        System.out.println(Math.tan(3.14)); // -0.0015...
        System.out.println(Math.asin(1.0)); // 1.57079...
        System.out.println(Math.acos(1.0)); // 0.0
        System.out.println(Math.sin(Math.PI / 6)); // sin(π/6) = 0.5
        //随机数
        System.out.println(Math.random());
    }
}
