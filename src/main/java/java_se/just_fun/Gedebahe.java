package java_se.just_fun;

import java.math.BigInteger;

public class Gedebahe {
    public static boolean isPrime(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return false; // 1 及以下不是质数
        }
        if (number.compareTo(BigInteger.valueOf(3)) <= 0) {
            return true; // 2 和 3 是质数
        }
        if (number.mod(BigInteger.TWO).equals(BigInteger.ZERO) || number.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
            return false; // 排除能被 2 或 3 整除的数
        }

        // 只需检查到 sqrt(number)，因为如果 n = a * b，其中一个因子必然小于等于 sqrt(n)
        BigInteger sqrtNumber = number.sqrt();
        for (BigInteger i = BigInteger.valueOf(5); i.compareTo(sqrtNumber) <= 0; i = i.add(BigInteger.TWO)) {
            if (number.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        BigInteger I  = new BigInteger("4");
        System.out.println(I);
        while (true){
            Boolean find = false;
            BigInteger q = new BigInteger("1");
            BigInteger f = new BigInteger("2");
            for(BigInteger i = new BigInteger("2");i.compareTo(I.divide(f))<=0;i=i.add(q)){
                BigInteger x = I.subtract(i);
                if(x.isProbablePrime(1)&&i.isProbablePrime(1)){
                    find = true;
                    System.out.println(x+" is prime "+i+" is prime");
                    break;

                }else {
                    if(isPrime(x)&&isPrime(i)){
                        find = true;
                        System.out.println(x+" is prime "+i+" is prime");
                        break;
                    }
                }


            }
            if(!find){
                System.out.println("find out!");
                break;
            }else {
                I=I.add(f);
                System.out.println(I+"\n");
            }

        }
    }
}
