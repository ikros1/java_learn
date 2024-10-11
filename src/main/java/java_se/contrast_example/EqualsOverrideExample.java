package java_se.contrast_example;

public class EqualsOverrideExample {
    /*
    讲到这里，顺便说一下java对equals()的要求。有以下几点：

1. 对称性：如果x.equals(y)返回是"true"，那么y.equals(x)也应该返回是"true"。
2. 反射性：x.equals(x)必须返回是"true"。
3. 类推性：如果x.equals(y)返回是"true"，而且y.equals(z)返回是"true"，那么z.equals(x)也应该返回是"true"。
4. 一致性：如果x.equals(y)返回是"true"，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是"true"。
5. 非空性，x.equals(null)，永远返回是"false"；x.equals(和x不同类型的对象)永远返回是"false"。
     */
    public static void main(String[] args) {
        // 新建2个相同内容的Person对象，
        // 再用equals比较它们是否相等
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        System.out.printf("%s\n", p1.equals(p2));

    }

    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " + age;
        }


        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            //如果是同一个对象返回true，反之返回false
            if (this == obj) {
                return true;
            }
            //判断是否类型相同
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
    }
}
