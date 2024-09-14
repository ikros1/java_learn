package java_se.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeWildcardExample {
    public static void main(String[] args) {
        //类型通配符一般是使用 ? 代替具体的类型参数。
        // 例如 List<?> 在逻辑上是 List<String>,List<Integer>
        // 等所有 List<具体类型实参> 的父类。

        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);
    }
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
}
