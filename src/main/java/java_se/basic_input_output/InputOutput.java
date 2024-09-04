package java_se.basic_input_output;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a int number: ");
        int n = sc.nextInt();
        System.out.println("Enter number is :"+n);
        System.out.println("Enter a String");
        String s = sc.next();
        System.out.println("Enter String is :"+s);
        System.out.println("Enter a double number");
        double d = sc.nextDouble();
        System.out.println("Enter double is :"+d);

    }
}
