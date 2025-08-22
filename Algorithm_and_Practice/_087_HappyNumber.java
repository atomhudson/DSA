package Algorithm_and_Practice;

import java.util.HashSet;

public class _087_HappyNumber {
    public static void main(String[] args) {
        System.out.println(HappyNumber(19));
    }
    static boolean HappyNumber(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(n != 1 && !hashSet.contains(n)){
            hashSet.add(n);
            n = sumOfSquare(n);
        }
        return n == 1;
    }
    static int sumOfSquare(int n){
        int sum = 0;
        while (n != 0){
            int remainder = n % 10;
            remainder *= remainder;
            sum += remainder;
            n /= 10;
        }
        return sum;
    }
}
