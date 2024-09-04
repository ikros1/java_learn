package java_se.random_example;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        //方法一:使用Math.random()
        //生成0~1之间的小数
        Double dou = Math.random();
        System.out.println(dou);
        //生成[0,10)
        int ran = (int) (Math.random() * 10);
        System.out.println(ran);
        //生成随机数[min,max)
        int max = 22;
        int min = 3;
        int rand = (int) (Math.random() * max-min)+min;
        System.out.println(rand);
        //方法二:使用Random类
        //生成[min,max)
        Random r = new Random();
        int max2 = 90;
        int min2 = 20;
        int rand2 = r.nextInt(max2-min2)+min2;
        System.out.println(rand2);
        //生成随机字母
        int num = (int) (Math.random() * 62);
        if (num < 10) {// [0,9]
            System.out.println(num);
        } else if (num < 36) {// [10,35]
            System.out.println((char) (num - 10 + 'a'));
        } else {// [36,61]
            System.out.println((char) (num - 36 + 'A'));
        }

    }
}
