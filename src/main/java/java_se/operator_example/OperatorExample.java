package java_se.operator_example;

public class OperatorExample {
    /*
    Java中的操作符用于对变量和值进行操作。
    一个值被称为操作数，而操作数（在两个操作数之间执行）则由操作符定义
    Java中的运算符有以下几种类型：

    算术运算符
    关系运算符
    逻辑运算符
    赋值运算符
    位操作符
    单一操作符
    三元运算符
    移位操作符

    算术运算符
    算术运算符用于执行简单的算术操作，如加法、减法等。
    运算符运算符名称例子(A=20, B=10)
    结果+加法A+B30-减法A-B10*乘法A*B200/除法A/B2%模数A%B0
    请看下面的程序：
    css 代码解读复制代码class operators {
      public static void main(String args[]) {
        int A = 20;
        int B = 10;
        System.out.println("A + B =" + (A + B)); // addition
        System.out.println("A - B =" + (A - B)); // subtraction
        System.out.println("A * B =" + (A * B)); // multiplication
        System.out.println("A / B =" + (A / B)); // division
        System.out.println("A % B =" + (A % B)); // modulus
      }
    }

    请看下面的输出：

    关系运算符
    关系运算符是用来比较数值的，它们返回真或假作为输出：
    操作符名称例子(A=20, B=10)结果<小于A<B假的<=小于或等于A<=B假的>大于A>B真实>=大于或等于A>=B真==等于A==B假!=不等于A！=B真
    请看下面的程序：
    csharp 代码解读复制代码class relation {
      public static void main(String args[]) {
        int A = 20;
        int B = 10;
        System.out.println("A < B:" + (A < B)); // less than
        System.out.println("A <= B:" + (A <= B)); // less than equal to
        System.out.println("A > B:" + (A > B)); // greater than
        System.out.println("A >= B:" + (A >= B)); // greater tahn equal to
        System.out.println("A == B:" + (A == B)); // equal to
        System.out.println("A != B=" + (A != B)); // not equal
      }
    }

    请看下面的代码：

    逻辑运算符
    这些运算符用于执行一些特殊的操作，
    如逻辑AND、逻辑OR等。它还将输出结果返回为真和假。
    操作符运算符名称例子(A=20,B=10)
    结果&&逻辑与A<30&&B>5真||逻辑ORA>10||B<5真!逻辑非!(A>=B)假
    请看下面的程序：
    csharp 代码解读复制代码class logical {
      public static void main(String args[]) {
        int A = 20;
        int B = 10;
        System.out.println("A && B =" + (A < 30 && B > 5)); // true if both are true
        System.out.println("A || B =" + (A > 10 || B < 5)); // true if one is true
        System.out.println("A ! B =" + (!(A > B))); // reverse the output
      }
    }

    请看下面的输出：

    赋值运算符
    赋值运算符是用来给变量赋值的。在Java中，（=）被称为赋值运算符。
    操作符例子A=20,B=10结果A=B将B的值分配给A10+=A+=B30-=A-=B10*=A*=B200/=A/=B2%=A%=B0

    位操作符
    这些运算符用于处理操作数的各个位：
    一些位操作符是：

    位数和 (&)
    位向OR (|)
    位数不运算 (~)
    位向XOR

    请看下面的代码：
    csharp 代码解读复制代码public class bitwise {
      public static void main(String args[]) {
        int A = 0x014;
        int B = 0x016;
        System.out.println("A & B=" + (A & B));
        System.out.println("A | B=" + (A | B));
        System.out.println(" ~A =" + (~A));
      }
    }

    请看下面的输出：

    单项运算符
    这些运算符用于只需要一个操作数的地方。
    各种类型的单项运算符如下。
    增量运算符
    它用于增加/增加1的值。它又分为两种类型

    前增量：首先，值被增加并转移到输出。
    后增加：首先给出输出，然后增加值。

    递减运算符
    它用于将值减少/降低1，它也有两种类型。

    pre-decrement：首先减少数值，然后显示输出。
    后减法：首先给出结果，然后减去数值。
    !-逻辑不用于倒置布尔值。

    请看下面的程序：
    csharp 代码解读复制代码class unary {
      public static void main(String args[]) {
        int A = 40;
        System.out.println(A++);
        System.out.println(++A);
        System.out.println(A--);
        System.out.println(--A);
      }
    }

    请看下面的输出：

    三元运算符
    它是if-else语句的简短版本，只用一行就可以写完。
    语法
    sql 代码解读复制代码Condition? if true:  if false


    见下面的程序：
    ini 代码解读复制代码class ternary {
      public static void main(String args[]) {
        int x = 20;
        int y = 10;
        int gre = (x > y) ? x : y;
        System.out.println(gre);
      }
    }

    见下面的输出：
    Java中的移位运算符
    移位运算符用于在2^n的乘法和除法方面对数字的位进行移位。
    它有两种类型：

    左移（<<）。在这种情况下，比特的值向左移动，这意味着该数字被乘以2^n
    右移（>>）。在这种情况下，比特的值向右移动，这意味着数字被2^n除以

    请看下面的程序：
    csharp 代码解读复制代码class shift {
      public static void main(String args[]) {
        System.out.println(4 << 2); // 4*2^n : 4*2^2=16
        System.out.println(4 << 3); // 4*2^3=32
        System.out.println(4 >> 2); // 4/2^2=1
        System.out.println(16 >> 3); // 16/2^3=2
      }
    }

    请看下面的输出：

     */
}
