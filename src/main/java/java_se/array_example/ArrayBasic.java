package java_se.array_example;

public class ArrayBasic {
    public static void main(String[] args) {
        //声明数组
        int[] a;
        //数组实例化
        a = new int[10];
        //数组使用
        //数组赋值
        a[0] = 1;
        //数组取值
        System.out.println(a[0]);
        //数组长度
        System.out.println(a.length);
        //数组初始化
        int[] b = new int[10];
        int[] c = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        //多维数组
        int[][] nums = new int[10][];
        nums[0] = new int[10];
        nums[0][0] = 1;
        System.out.println(nums[0][0]);
        System.out.println(nums.length);
        System.out.println(nums[0].length);
        nums[1] =  new int[]{1,2};
        System.out.println(nums[1][0]);
        System.out.println(nums[1].length);

    }
}
