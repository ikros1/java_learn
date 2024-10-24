package java_se.string_method_example;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        String[] names = {"bob", "alice", "bob", "bob", "bob", "bob", "bob"};
        StringJoiner joiner = new StringJoiner(",");
        for (String name : names) {
            joiner.add(name);
        }
        System.out.println(joiner.toString());
        StringJoiner joiner2 = new StringJoiner(",","hello ",".");
        for (String name : names) {
            joiner2.add(name);
        }
        System.out.println(joiner2.toString());
        //不需要开头和结尾时，利用String的内部方法join更方便
        String s = String.join(",",names);
        System.out.println(s);

    }
}
