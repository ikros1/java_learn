package java_se.array_example;

public class ArrayTraversal {
    public static void main(String[] args) {
        int[] scores = new int[100];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i;
        }
        for(int i=0;i<scores.length;i++) {
            System.out.println(scores[i]);
        }

        System.out.println("========");
        /*
         * 	新型for循环，增强for循环，foreach循环，for冒号循环，迭代循环
         *  for(元素的数据类型  变量 : 数组名){
         * 	   //每次循环 ，变量的值，就是数组中的每个元素值
         *  }
         */
        for(int score : scores) {
            System.out.println(score);
        }
    }
}
