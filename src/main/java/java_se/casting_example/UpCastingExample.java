package java_se.casting_example;

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

class Student extends Person {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

public class UpCastingExample {
    public static void main(String[] args) {
        Student s = new Student();
        /*
        这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。
        向上转型实际上是把一个子类型安全地变为更加抽象的父类型：
         */
        Person p = s; // upcasting, ok
        Object o1 = p; // upcasting, ok
        Object o2 = s; // upcasting, ok
    }
}
