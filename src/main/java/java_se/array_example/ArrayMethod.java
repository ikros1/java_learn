package java_se.array_example;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.util.*;

public class ArrayMethod {
    public static void main(String[] args) {
        /*
        一般数组是不能添加元素的，因为他们在初始化时就已定好长度了，不能改变长度。

        向数组中添加元素思路
        第一步：把数组转化为集合

        list = Arrays.asList(array);
        第二步：向集合中添加元素

        复制
        list.add(index, element);
        第三步：将集合转化为数组

        list.toArray(newArray);

         */
        String[] arr = {"ID", "姓名", "年龄"};
        // 定义数组
        List<String> list1 = Arrays.asList(arr);
        // 将数组转化为集合 1

        List<String> list2 = new ArrayList<>();
        list2.add("性别");
        list2.add("出生日期");
        // 定义集合 2 ，并向其中添加元素: 性别、出生日期

        List<String> titleList = new ArrayList<String>();
        // 定义新集合

        titleList.addAll(list1);
        // 将集合 1 中的元素添加到新集合中

        titleList.addAll(list2);
        // 将集合 2 中的元素添加到新集合中

        String[] newArr = titleList.toArray(new String[titleList.size()]);
        // 将新集合转化回新数组

        System.out.println(Arrays.toString(newArr));
        // 将数组转化为字符串，输出


        //判断数组内是否包含某个值
        String[] stringArray = { "a", "b", "c", "d", "e" };
        boolean b = Arrays.asList(stringArray).contains("a");
        System.out.println(b);

        //连接两个数组
        int[] intArray = { 1, 2, 3, 4, 5 };
        int[] intArray2 = { 6, 7, 8, 9, 10 };
        // Apache Commons Lang library
        int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
        System.out.println(Arrays.toString(combinedIntArray));

        //根据分隔符拼接数组元素，并去掉最后一个分隔符
        // containing the provided list of elements
        // Apache common lang
        String j = StringUtils.join(new String[] { "a", "b", "c" }, ", ");
        System.out.println(j);
        // a, b, c

        //arraylist转数组
        String[] stringArray2 = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray2));
        String[] stringArr = new String[arrayList.size()];
        arrayList.toArray(stringArr);
        for (String s : stringArr)
            System.out.println(s);

        //array转set
        Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
        System.out.println(set);
        //[d, e, b, c, a]

        //反转数组
        int[] intArray22 = { 1, 2, 3, 4, 5 };
        ArrayUtils.reverse(intArray22);
        System.out.println(Arrays.toString(intArray22));
        //[5, 4, 3, 2, 1]

        //删除数组元素
        int[] intArray7 = { 1, 2, 3, 4, 5 };
        int[] removed = ArrayUtils.removeElement(intArray7, 3);//create a new array
        System.out.println(Arrays.toString(removed));

        //整形转字节数组
        byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
        for (byte t : bytes) {
            System.out.format("0x%x ", t);
        }
    }


}
