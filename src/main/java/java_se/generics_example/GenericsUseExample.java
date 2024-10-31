package java_se.generics_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsUseExample {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<Number>();
        list.add(123);
        list.add(12.34);
        Number first = list.get(0);
        Number second = list.get(1);
        System.out.println(first);
        System.out.println(second);
        /*
        编译器如果能自动推断出泛型类型，就可以省略后面的泛型类型。例如，对于下面的代码：

        List<Number> list = new ArrayList<Number>();
        编译器看到泛型类型List<Number>就可以自动推断出后面的ArrayList<T>的泛型类型必须是ArrayList<Number>，因此，可以把代码简写为：

        // 可以省略后面的Number，编译器可以自动推断泛型类型：
        List<Number> list = new ArrayList<>();
        泛型接口
除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：

public interface Comparable<T> {

     * 返回负数: 当前实例比参数o小
     * 返回0: 当前实例与参数o相等
     * 返回正数: 当前实例比参数o大

        int compareTo(T o);
    }
    可以直接对String数组进行排序：

            // sort
            import java.util.Arrays;

    public class Main {
        public static void main(String[] args) {
            String[] ss = new String[] { "Orange", "Apple", "Pear" };
            Arrays.sort(ss);
            System.out.println(Arrays.toString(ss));
        }
    }
    这是因为String本身已经实现了Comparable<String>接口。如果换成我们自定义的Person类型试试：

            // sort
            import java.util.Arrays;

    public class Main {
        public static void main(String[] args) {
            Person[] ps = new Person[] {
                    new Person("Bob", 61),
                    new Person("Alice", 88),
                    new Person("Lily", 75),
            };
            Arrays.sort(ps);
            System.out.println(Arrays.toString(ps));
        }
    }

    class Person {
        String name;
        int score;
        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String toString() {
            return this.name + "," + this.score;
        }
    }
    运行程序，我们会得到ClassCastException，即无法将Person转型为Comparable。我们修改代码，让Person实现Comparable<T>接口：
         */
        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}
class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    public String toString() {
        return this.name + "," + this.score;
    }
}
