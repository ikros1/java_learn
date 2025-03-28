package java_se.collection_example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Stack只有入栈和出栈的操作：

把元素压栈：push(E)；
把栈顶的元素“弹出”：pop()；
取栈顶元素但不弹出：peek()。
在Java中，我们用Deque可以实现Stack的功能：

把元素压栈：push(E)/addFirst(E)；
把栈顶的元素“弹出”：pop()/removeFirst()；
取栈顶元素但不弹出：peek()/peekFirst()。
为什么Java的集合类没有单独的Stack接口呢？因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。

当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。

Stack的作用
Stack在计算机中使用非常广泛，JVM在处理Java方法调用的时候就会通过栈这种数据结构维护方法调用的层次。例如：

static void main(String[] args) {
    foo(123);
}

static String foo(x) {
    return "F-" + bar(x + 1);
}

static int bar(int x) {
    return x << 2;
}
JVM会创建方法调用栈，每调用一个方法时，先将参数压栈，然后执行对应的方法；当方法返回时，返回值压栈，调用方法通过出栈操作获得方法返回值。

因为方法调用栈有容量限制，嵌套调用过多会造成栈溢出，即引发StackOverflowError：

// 测试无限递归调用
public class Main {
    public static void main(String[] args) {
        increase(1);
    }

    static int increase(int x) {
        return increase(x) + 1;
    }
}
我们再来看一个Stack的用途：对整数进行进制的转换就可以利用栈。

例如，我们要把一个int整数12500转换为十六进制表示的字符串，如何实现这个功能？

首先我们准备一个空栈：

│   │
│   │
│   │
│   │
│   │
└───┘
然后计算12500÷16=781…4，余数是4，把余数4压栈：

│   │
│   │
│   │
│   │
│ 4 │
└───┘
然后计算781÷16=48…13，余数是13，13的十六进制用字母D表示，把余数D压栈：

│   │
│   │
│   │
│ D │
│ 4 │
└───┘
然后计算48÷16=3…0，余数是0，把余数0压栈：

│   │
│   │
│ 0 │
│ D │
│ 4 │
└───┘
最后计算3÷16=0…3，余数是3，把余数3压栈：

│   │
│ 3 │
│ 0 │
│ D │
│ 4 │
└───┘
当商是0的时候，计算结束，我们把栈的所有元素依次弹出，组成字符串30D4，这就是十进制整数12500的十六进制表示的字符串。

计算中缀表达式
在编写程序的时候，我们使用的带括号的数学表达式实际上是中缀表达式，即运算符在中间，例如：1 + 2 * (9 - 5)。

但是计算机执行表达式的时候，它并不能直接计算中缀表达式，而是通过编译器把中缀表达式转换为后缀表达式，例如：1 2 9 5 - * +。

这个编译过程就会用到栈。我们先跳过编译这一步（涉及运算优先级，代码比较复杂），看看如何通过栈计算后缀表达式。

计算后缀表达式不考虑优先级，直接从左到右依次计算，因此计算起来简单。首先准备一个空的栈：

│   │
│   │
│   │
│   │
│   │
└───┘
然后我们依次扫描后缀表达式1 2 9 5 - * +，遇到数字1，就直接扔到栈里：

│   │
│   │
│   │
│   │
│ 1 │
└───┘
紧接着，遇到数字2，9，5，也扔到栈里：

│   │
│ 5 │
│ 9 │
│ 2 │
│ 1 │
└───┘
接下来遇到减号时，弹出栈顶的两个元素，并计算9-5=4，把结果4压栈：

│   │
│   │
│ 4 │
│ 2 │
│ 1 │
└───┘
接下来遇到*号时，弹出栈顶的两个元素，并计算2*4=8，把结果8压栈：

│   │
│   │
│   │
│ 8 │
│ 1 │
└───┘
接下来遇到+号时，弹出栈顶的两个元素，并计算1+8=9，把结果9压栈：

│   │
│   │
│   │
│   │
│ 9 │
└───┘
扫描结束后，没有更多的计算了，弹出栈的唯一一个元素，得到计算结果9。

练习
请利用Stack把一个给定的整数转换为十六进制：

// 转十六进制
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        return "";
    }
}
进阶练习：

请利用Stack把字符串中缀表达式编译为后缀表达式，然后再利用栈执行后缀表达式获得计算结果：

// 高难度练习，慎重选择！
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String exp = "1 + 2 * (9 - 5)";
        SuffixExpression se = compile(exp);
        int result = se.execute();
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        // TODO:
        return new SuffixExpression();
    }
}

class SuffixExpression {
    int execute() {
        // TODO:
        return 0;
    }
}
进阶练习2：

请把带变量的中缀表达式编译为后缀表达式，执行后缀表达式时，传入变量的值并获得计算结果：

// 超高难度练习，慎重选择！
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String exp = "x + 2 * (y - 5)";
        SuffixExpression se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        // TODO:
        return new SuffixExpression();
    }
}

class SuffixExpression {
    int execute(Map<String, Integer> env) {
        // TODO:
        return 0;
    }
}
下载练习

小结
栈（Stack）是一种后进先出（LIFO）的数据结构，操作栈的元素的方法有：

把元素压栈：push(E)；
把栈顶的元素“弹出”：pop(E)；
取栈顶元素但不弹出：peek(E)。
在Java中，我们用Deque可以实现Stack的功能，注意只调用push()/pop()/peek()方法，避免调用Deque的其他方法；

不要使用遗留类Stack。
 */
public class StackExample {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<Integer> stack = new LinkedList<Integer>();
        while (n != 0) {
            stack.addFirst(n % 16);
            n /= 16;
        }
        StringBuilder sb = new StringBuilder();
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9","A", "B", "C", "D", "E", "F"};
        while (!stack.isEmpty()) {
            sb.append(str[stack.removeFirst()]);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
