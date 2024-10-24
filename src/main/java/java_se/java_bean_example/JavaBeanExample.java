package java_se.java_bean_example;

import java.beans.*;

public class JavaBeanExample {
    public static void main(String[] args) throws Exception{
        /*
        JavaBean的由来：

        想想 Java 的图标是什么？没错，是一杯咖啡。
        想想咖啡的原料是什么？没错，是咖啡豆。


        这么一看 Java Bean 代表什么就很清楚了，它是一种类，而且是特殊的、可重用的类。
        Java language 是一种面向对象的编程语言，类是面向对象的编程语言的基础；可重用又是面向对象编程思想存在的意义之一，所以起名 Bean 很是形象。


        概念：

        正如 Java 是咖啡的一种，不是所有的咖啡都是 Java 一样。并非所有的类都是 Java Bean，其是一种特殊的类，具有以下特征：

        提供一个默认的无参构造函数。
        需要被序列化并且实现了 Serializable 接口。
        可能有一系列可读写属性，并且一般是 private 的。
        可能有一系列的 getter 或 setter 方法。 根据封装的思想，我们使用 get 和 set 方法封装 private 的属性，并且根据属性是否可读写来选择封装方法。
        作用：

        仔细观察 Java Bean 可发现，其最大的特征是私有的属性，getter 和 setter 方法也都是绕着这些属性来设计的。
        想象一下存在这样一个箱子，其内部被分割成几个格子，每个格子用来存放特定的物品，工人取出或者放入物品后封箱，然后叫了个快递把箱子发出去了。这个箱子就是 Java Bean 啊，取出、放入就是getter、setter，物品就是属性，封箱发出就是序列化和传输。
        那么 Java Bean 的作用也就是把一组数据组合成一个特殊的类便于传输。 Java Bean 可以用在图形界面的可视化设计、JSP 封装数据保存到数据库、Android AIDL 跨进程通信，Spring框架等场景中。
         我们通常把一组对应的读方法（getter）和写方法（setter）称为属性（property）。例如，name属性：

        对应的读方法是String getName()
        对应的写方法是setName(String)
        只有getter的属性称为只读属性（read-only），例如，定义一个age只读属性：

        对应的读方法是int getAge()
        无对应的写方法setAge(int)
        类似的，只有setter的属性称为只写属性（write-only）。

        很明显，只读属性很常见，只写属性不常见。

        属性只需要定义getter和setter方法，不一定需要对应的字段。例如，child只读属性定义如下：

        public class Person {
            private String name;
            private int age;

            public String getName() { return this.name; }
            public void setName(String name) { this.name = name; }

            public int getAge() { return this.age; }
            public void setAge(int age) { this.age = age; }

            public boolean isChild() {
                return age <= 6;
            }
        }
        可以看出，getter和setter也是一种数据封装的方法。
         */
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }
    class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
