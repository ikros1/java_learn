package java_se.array_example;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        //因为元素只能为对象，所以使用的类型不能为基础数据类型，需要使用基本类型的包装类
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);
        System.out.println(sites.size());
        System.out.println(sites.get(1));  // 访问第二个元素
        sites.add("Google");
        Collections.sort(sites);  // 字母排序
        for (String i : sites) {
            System.out.println(i);
        }
        sites.set(1, "Google");
        System.out.println(sites);
        sites.remove(3);
        System.out.println(sites);
        System.out.println(sites.size());
        for (int i = 0; i < sites.size(); i++) {
            System.out.println(sites.get(i));
        }
        for (String i : sites) {
            System.out.println(i);
        }
    }
}
