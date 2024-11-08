package java_se.collection_example;
/*
我们知道List是一种有序链表：List内部按照放入元素的先后顺序存放，并且每个元素都可以通过索引确定自己的位置。

List还提供了boolean contains(Object o)方法来判断List是否包含某个指定元素。此外，int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1。

我们来看一个例子：

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains("C")); // true
        System.out.println(list.contains("X")); // false
        System.out.println(list.indexOf("C")); // 2
        System.out.println(list.indexOf("X")); // -1
    }
}
这里我们注意一个问题，我们往List中添加的"C"和调用contains("C")传入的"C"是不是同一个实例？

如果这两个"C"不是同一个实例，这段代码是否还能得到正确的结果？我们可以改写一下代码测试一下：

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println(list.contains(new String("C"))); // true or false?
        System.out.println(list.indexOf(new String("C"))); // 2 or -1?
    }
}
因为我们传入的是new String("C")，所以一定是不同的实例。结果仍然符合预期，这是为什么呢？

因为List内部并不是通过==判断两个元素是否相等，而是使用equals()方法判断两个元素是否相等，例如contains()方法可以实现如下：

public class ArrayList {
    Object[] elementData;
    public boolean contains(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (o.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }
}
因此，要正确使用List的contains()、indexOf()这些方法，放入的实例必须正确覆写equals()方法，否则，放进去的实例，查找不到。我们之所以能正常放入String、Integer这些对象，是因为Java标准库定义的这些类已经正确实现了equals()方法。

我们以Person对象为例，测试一下：

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = List.of(
            new Person("Xiao Ming"),
            new Person("Xiao Hong"),
            new Person("Bob")
        );
        System.out.println(list.contains(new Person("Bob"))); // false
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}
不出意外，虽然放入了new Person("Bob")，但是用另一个new Person("Bob")查询不到，原因就是Person类没有覆写equals()方法。

编写equals
如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：

自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
对null的比较：即x.equals(null)永远返回false。
上述规则看上去似乎非常复杂，但其实代码实现equals()方法是很简单的，我们以Person类为例：

public class Person {
    public String name;
    public int age;
}
首先，我们要定义“相等”的逻辑含义。对于Person类，如果name相等，并且age相等，我们就认为两个Person实例相等。

因此，编写equals()方法如下：

public boolean equals(Object o) {
    if (o instanceof Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
    return false;
}
对于引用字段比较，我们使用equals()，对于基本类型字段的比较，我们使用==。

如果this.name为null，那么equals()方法会报错，因此，需要继续改写如下：

public boolean equals(Object o) {
    if (o instanceof Person p) {
        boolean nameEquals = false;
        if (this.name == null && p.name == null) {
            nameEquals = true;
        }
        if (this.name != null) {
            nameEquals = this.name.equals(p.name);
        }
        return nameEquals && this.age == p.age;
    }
    return false;
}
如果Person有好几个引用类型的字段，上面的写法就太复杂了。要简化引用类型的比较，我们使用Objects.equals()静态方法：

public boolean equals(Object o) {
    if (o instanceof Person p) {
        return Objects.equals(this.name, p.name) && this.age == p.age;
    }
    return false;
}
因此，我们总结一下equals()方法的正确编写方法：

先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
对引用类型用Objects.equals()比较，对基本类型直接用==比较。
使用Objects.equals()比较两个引用类型是否相等的目的是省去了判断null的麻烦。两个引用类型都是null时它们也是相等的。

如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。

练习
给Person类增加equals方法，使得调用indexOf()方法返回正常：
 */

import java.util.List;
import java.util.Objects;

public class RewriteListExample {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
    /*
    在Java中，`instanceof` 关键字用于检查对象是否是指定类型或其子类的实例。如果对象是该类型或其子类的实例，则 `instanceof` 表达式返回 `true`；否则，返回 `false`。

你提到的表达式 `o instanceof Person person` 是Java 16引入的新特性，称为模式匹配的 `instanceof`。这种新的语法不仅检查对象 `o` 是否为 `Person` 类型的实例，而且如果是的话，它还会自动将 `o` 转换为 `Person` 类型，并将其绑定到新声明的变量 `person` 上。

这里是一个例子来说明这个过程：

```java
Object o = new Person(); // 假设 Person 是一个已定义的类

if (o instanceof Person person) {
    // 在这个块中，`person` 已经是 Person 类型了，不需要额外的类型转换
    System.out.println(person.getName()); // 假设 getName() 是 Person 类的一个方法
} else {
    // 如果 o 不是 Person 的实例，那么这个 else 块会被执行
}
```

在这个例子中，如果 `o` 实际上是一个 `Person` 对象（或者它的子类的对象），那么 `person` 变量将会引用同一个对象，但是作为 `Person` 类型。因此，在 `if` 语句体内部，你可以直接使用 `person` 变量调用 `Person` 类的方法，如 `getName()`，而无需显式地进行类型转换。

需要注意的是，`person` 变量只在 `if` 语句块内有效。一旦程序执行离开这个块，`person` 就不再可用。此外，如果 `o` 不是 `Person` 类型的实例，那么 `else` 语句块将被执行，而不会创建 `person` 变量。
     */
}